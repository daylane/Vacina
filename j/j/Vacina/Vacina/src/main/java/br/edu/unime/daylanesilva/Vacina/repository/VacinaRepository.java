package br.edu.unime.daylanesilva.Vacina.repository;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VacinaRepository extends MongoRepository<Vacina, String> {

    Optional<Vacina> findById(String id);

    List<Vacina> findAll();

    List<Vacina> findByFabricante(String fabricante);
}
