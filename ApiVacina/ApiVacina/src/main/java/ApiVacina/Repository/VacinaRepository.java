package ApiVacina.Repository;

import ApiVacina.dto.VacinaDto;
import ApiVacina.entity.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VacinaRepository extends MongoRepository<Vacina, String> {

    List<Vacina> findByFabricanteAndVacina(String fabricante, String vacina);
    List<Vacina> findByVacina(String vacina);
    List<Vacina> findByFabricante(String fabricante);

    List<Vacina> findAll();


}

