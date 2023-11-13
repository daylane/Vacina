package br.edu.unime.daylanesilva.Vacina.repository;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface VacinaRepository extends MongoRepository<Vacina, String> {


    public default List<Vacina> findVacina(String id) {
        List<Vacina> vacinas = listarVacinas();
        return vacinas.stream()
                .filter(Objects::nonNull)
                .filter(vacina -> vacina.getId().equals(id))
                .collect(Collectors.toList());
    }


    static List<Vacina> listarVacinas(){
        return Arrays.asList(
                new Vacina("Moderna", "MD67890", LocalDate.of(2019, 11, 30), 1,30),
                new Vacina("AstraZeneca", "AZ45678", LocalDate.of(2021, 10, 31), 3,15),
                new Vacina("Generic Pharma", "FLU2023", LocalDate.of(2020, 11, 15), 3,90),
                new Vacina("Johnson & Johnson", "JJ78901", LocalDate.of(2021, 9, 30), 1,21),
                new Vacina("Pfizer", "PF12345", LocalDate.of(2022, 12, 31), 2,21)
        );
    }

    @Override
    Optional<Vacina> findById(String Id);


}
