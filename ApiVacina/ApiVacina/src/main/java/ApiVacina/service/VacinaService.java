package ApiVacina.service;


import ApiVacina.dto.VacinaDto;
import ApiVacina.Repository.VacinaRepository;
import ApiVacina.entity.Vacina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;

    public List<Vacina> listarVacinas() {
        return vacinaRepository.findAll();
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


    public Vacina atualizarVacina(@Valid VacinaDto novaVacina, String id) {

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
