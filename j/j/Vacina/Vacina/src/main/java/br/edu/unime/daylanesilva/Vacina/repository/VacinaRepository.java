package br.edu.unime.daylanesilva.Vacina.repository;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.serviceTest.VacinaService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
>>>>>>> origin/develop

@Repository
public interface VacinaRepository extends MongoRepository<Vacina,String> {

    Optional<Vacina> findById(String id);

    List<Vacina> findAll();
}
