package ApiVacina.service;


import ApiVacina.Controller.VacinaController;
import ApiVacina.dto.VacinaDto;
import ApiVacina.Repository.VacinaRepository;
import ApiVacina.entity.Vacina;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;

    private Logger logger = LoggerFactory.getLogger(VacinaService.class);

    public List<VacinaDto> listarVacinas() {
        List<Vacina> vacinas;
        vacinas = vacinaRepository.findAll();
        logger.info("retornou " + vacinas.get(0));

        return vacinas.stream().map(vacina -> {
            VacinaDto vacinaDto = new VacinaDto();
            vacinaDto.setVacina(vacina.getVacina());
            vacinaDto.setFabricante(vacina.getFabricante());
            vacinaDto.setTotal_de_doses(vacina.getNumeroDoses());
            vacinaDto.setIntervalo_entre_doses(vacina.getIntervaloMinimoEntreDoses());
            return vacinaDto;
        }).collect(Collectors.toList());

    }

    public Vacina registrarVacina(Vacina vacina) {
        vacinaRepository.insert(vacina);
        return vacina;
    }


    public void deletarVacina(String id) {
        Optional<Vacina> optionalVacina = findByid(id);
        optionalVacina.ifPresent(value -> vacinaRepository.delete(value));
    }

    public Optional<Vacina> findByid(String id) {
        if (id == null) {
            return null;
        }
        return vacinaRepository.findById(id);
    }


    public Vacina atualizarVacina(Vacina novaVacina, String id) {

        Optional<Vacina> optionalVacina = findByid(id);

        if (optionalVacina.isPresent()) {
            Vacina vacinaExistente = optionalVacina.get();

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

    public void vacinasMock(){
        List<Vacina> vacinasmock(){
            new Vacina("Pfizer","LF3343N",LocalDate.of(2023,12,31),2,50);
            new Vacina("Moderna", "B84BF4", LocalDate.of(2022, 10, 13), 2, 28);
            new Vacina("Johnson & Johnson", "N49FNKGH", LocalDate.of(2023, 4, 21), 1, 0);
            new Vacina("Generic Pharma", "DB4-D43", LocalDate.of(2023, 12, 1O), 3, 4)

        }
        vacinasmock.forEach(vacina -> vacinaRepository.insert(vacina));
    }
    }
