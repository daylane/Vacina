package br.edu.unime.daylanesilva.Vacina.repository;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends MongoRepository<Vacina, String> {

}
