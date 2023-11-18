package ApiVacina.repositoryTest;

import ApiVacina.Repository.VacinaRepository;
import ApiVacina.entity.Vacina;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@DataMongoTest
public class VacinaRepositoryTest {
    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private VacinaRepository vacinaRepository;

    private Vacina vacinaSetUp;
    private Vacina vacina;
    private List<Vacina> vacinaList;

    @BeforeEach
    public void setUp() {
        vacinaSetUp = new Vacina();
        vacinaSetUp.setId("1");
        vacinaSetUp.setFabricante("Pfizer");
        vacinaSetUp.setLote("ABC123");
        vacinaSetUp.setDataValidade(LocalDate.of(2023, 21, 31));
        vacinaSetUp.setNumeroDoses(2);
        vacinaSetUp.setIntervaloMinimoEntreDoses(21);

        vacina = new Vacina();
        vacina.setId("2");
        vacina.setFabricante("AstraZeneca");
        vacina.setLote("XYZ456");
        vacina.setDataValidade(LocalDate.of(2024, 01, 01));
        vacina.setNumeroDoses(2);
        vacina.setIntervaloMinimoEntreDoses(90);

        vacinaList = new ArrayList<>();
        vacinaList.add(vacinaSetUp);
        vacinaList.add(vacina);

    }

    @Test
    @DisplayName("Deve retornar uma vacina com o id informado do repository")
    void testeFindById() {

        when(mongoTemplate.findById("1", Vacina.class)).thenReturn(vacinaSetUp);

        Optional<Vacina> result = vacinaRepository.findById("1");

        assertTrue(result.isPresent());
        assertEquals(vacinaSetUp, result.get());
    }

    @Test
    public void testFindAll() {

        when(mongoTemplate.findAll(Vacina.class)).thenReturn(vacinaList);


        List<Vacina> result = vacinaRepository.findAll();


        assertEquals(vacinaList, result);

    }
}
