package br.edu.unime.daylanesilva.Vacina.repository;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VacinaRepository {
    List<Vacina> findAll();

    Vacina save(Vacina vacina);

    void deleteById(String id);
}
