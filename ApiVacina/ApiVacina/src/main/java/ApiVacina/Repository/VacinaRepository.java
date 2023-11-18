package ApiVacina.Repository;

import ApiVacina.entity.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    Optional<Vacina> findById(String id);

    List<Vacina> findAll();
}
