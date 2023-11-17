package br.edu.unime.daylanesilva.Vacina.serviceTest;

import br.edu.unime.daylanesilva.Vacina.dto.VacinaDTO;
import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.exception.BusinessException;
import br.edu.unime.daylanesilva.Vacina.exception.VacinaNotFoundException;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
public class VacinaService {

    @Autowired
    private static VacinaRepository vacinaRepository;

    public static List<Vacina> listarVacinas() {
        return vacinaRepository.findAll();
    }

    public Vacina registrarVacina(@Valid Vacina vacina) {
        if (vacina != null) {
            vacinaRepository.save(vacina);
        } else {
            throw new IllegalArgumentException("A vacina não pode ser nula");
        }
        return vacina;
    }


    public void deletarVacina(String id) {
        Optional<Vacina> optionalVacina = findByid(id);
        optionalVacina.ifPresent(value -> vacinaRepository.delete(value));
    }

    public Optional<Vacina> findByid(String id) {
        if (id == null) {
            throw new BusinessException("Id é obrigatório!");
        }
        try {
            return vacinaRepository.findById(id);
        } catch (final Exception e) {
            throw new BusinessException(format("Erro ao buscar vacina pelo ID = %s", id), e);
        }
    }


    public Vacina atualizarVacina(@Valid VacinaDTO novaVacina, String id) {

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

