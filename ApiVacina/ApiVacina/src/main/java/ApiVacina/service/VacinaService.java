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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;

    private Logger logger = LoggerFactory.getLogger(VacinaService.class);

    public List<VacinaDto> listarVacinas(String fabricante, String vacina) {
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



}