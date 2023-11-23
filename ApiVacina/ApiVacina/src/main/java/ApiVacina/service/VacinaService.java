package ApiVacina.service;


import ApiVacina.Controller.VacinaController;
import ApiVacina.dto.VacinaDto;
import ApiVacina.Repository.VacinaRepository;
import ApiVacina.entity.Vacina;
import ApiVacina.exceptions.DataValidadeException;
import ApiVacina.exceptions.LoteDuplicadoException;
import ApiVacina.exceptions.VacinaNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;

    private Logger logger = LoggerFactory.getLogger(VacinaService.class);

    public List<Vacina> listarVacinas(String fabricante, String vacina) {
        List<Vacina> vacinas;

        if (fabricante != null && vacina != null) {
            logger.info("Pesquisando fabricante e vacina.");
            vacinas = vacinaRepository.findByFabricanteAndVacina(fabricante, vacina);
        } else if (fabricante != null) {
            logger.info("Pesquisando fabricante.");
            vacinas = vacinaRepository.findByFabricante(fabricante);
        } else if (vacina != null) {
            logger.info("Pesquisando vacina.");
            vacinas = vacinaRepository.findByVacina(vacina);
        } else {
            logger.info("Pesquisando tudo.");
            vacinas = vacinaRepository.findAll();
        }
        if (vacinas.isEmpty()) {
            logger.info("Nenhuma vacina encontrada.");
        }

        return vacinas;
        }



        //logger.info("retornou " + vacinas.get(0));

        /*return vacinas.stream().map(vacinadto -> {
            VacinaDto vacinaDto = new VacinaDto();
            vacinaDto.setVacina(vacinadto.getVacina());
            vacinaDto.setFabricante(vacinadto.getFabricante());
            vacinaDto.setTotal_de_doses(vacinadto.getNumeroDoses());
            vacinaDto.setIntervalo_entre_doses(vacinadto.getIntervaloMinimoEntreDoses());
            return vacinaDto;
        }).collect(Collectors.toList());*/


    public Vacina registrarVacina(Vacina vacina) {
        LocalDate DataValidade = vacina.getDataValidade();
        if (DataValidade != null && DataValidade.isAfter(LocalDate.now())) {
            throw new DataValidadeException("A data de validade não pode ser no futuro.");
        }
        if (vacinaRepository.existsByLote(vacina.getLote())) {
            throw new LoteDuplicadoException("Já existe uma vacina com o mesmo numero de lote: " + vacina.getLote());
        }
        try{
            vacinaRepository.insert(vacina);
            return vacina;
        }catch(Exception ex){
            throw new VacinaNotFoundException("Não foi possivel inserir vacina");
        }

    }


    public void deletarVacina(String id) {
        Optional<Vacina> optionalVacina = findByid(id);
        optionalVacina.ifPresent(value -> vacinaRepository.delete(value));
    }

    public Optional<Vacina> findByid(String id) {
        Optional<Vacina> vacinaOptional = vacinaRepository.findById(id);
        if(vacinaOptional.isPresent()){
            return vacinaOptional;
        }else{
            throw new VacinaNotFoundException("Vacina não encontrada com o id: "+ id);
        }
    }


    public Vacina atualizarVacina(Vacina novaVacina, String id) {

        Optional<Vacina> optionalVacina = findByid(id);

        if (optionalVacina.isPresent()) {
            Vacina vacinaExistente = optionalVacina.get();
            vacinaExistente.setVacina(novaVacina.getVacina());
            vacinaExistente.setFabricante(novaVacina.getFabricante());
            vacinaExistente.setLote(novaVacina.getLote());
            vacinaExistente.setDataValidade(novaVacina.getDataValidade());
            vacinaExistente.setNumeroDoses(novaVacina.getNumeroDoses());
            vacinaExistente.setIntervaloMinimoEntreDoses(novaVacina.getIntervaloMinimoEntreDoses());


            return vacinaRepository.save(vacinaExistente);
        } else {
            return null;
        }

    }


    }
