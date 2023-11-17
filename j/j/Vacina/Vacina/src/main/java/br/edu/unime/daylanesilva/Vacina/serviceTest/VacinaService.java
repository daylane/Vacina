package br.edu.unime.daylanesilva.Vacina.serviceTest;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.exception.BusinessException;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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
    /*@CachePut("vacinaCache")*/
    public Vacina registrarVacina(@Valid Vacina vacina){
        if(vacina != null){
            vacinaRepository.save(vacina);
        } else {
            throw new IllegalArgumentException("A vacina não pode ser nula");
        }
        return vacina;
    }



    public void deletarVacina(String id) {
        Optional<Vacina> optionalVacina = buscarVacina(id);
        vacinaRepository.deleteById(id);
    }

    public Optional<Vacina> buscarVacina(String id) {
        if (id == null) {
            throw new BusinessException("Id é obrigatório!");
        }
        try {
            return vacinaRepository.findById(id);
        } catch (final Exception e) {
            throw new BusinessException(format("Erro ao buscar vacina pelo ID = %s", id), e);
        }
    }




    public Vacina atualizarVacina(Vacina novaVacina, String id) {

       try{
           Optional<Vacina> optionalVacina = buscarVacina(id);

        return vacinaRepository.save(optionalVacina.get());
       } catch (final Exception e){
           throw new BusinessException(format("Erro ao atualizar com o ID + %s",id),e);
       }
       }
}

