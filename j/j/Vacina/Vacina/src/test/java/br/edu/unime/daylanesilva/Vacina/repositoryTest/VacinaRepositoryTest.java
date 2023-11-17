package br.edu.unime.daylanesilva.Vacina.repositoryTest;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
<<<<<<< HEAD
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataMongoTest
@RunWith(MockitoJUnitRunner.class)
class VacinaRepositoryTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private VacinaRepository vacinaRepository;

    private Vacina vacina1;
    private Vacina vacina2;
    private List<Vacina> vacinaList;

    @Before
    public void setUp() {
        vacina1 = new Vacina();
        vacina1.setId("1");
        vacina1.setFabricante("Pfizer");
        vacina1.setLote("ABC123");
        vacina1.setDataValidade(LocalDate.of(2023, 21, 31));
        vacina1.setNumeroDoses(2);
        vacina1.setIntervaloMinimoEntreDoses(21);

        vacina2 = new Vacina();
        vacina2.setId("2");
        vacina2.setFabricante("AstraZeneca");
        vacina2.setLote("XYZ456");
        vacina2.setDataValidade(LocalDate.of(2024, 01, 01));
        vacina2.setNumeroDoses(2);
        vacina2.setIntervaloMinimoEntreDoses(90);


        vacinaList = new ArrayList<>();
        vacinaList.add(vacina1);
        vacinaList.add(vacina2);


    }

    @Test
    @DisplayName("Deve retornar uma vacina com o id informado do repository")
    void testeFindById() {

        when(mongoTemplate.findById("1", Vacina.class)).thenReturn(vacina1);

        Optional<Vacina> result = vacinaRepository.findById("1");

        assertTrue(result.isPresent());
        assertEquals(vacina1, result.get());
    }

    @Test
    public void testFindAll() {

        when(mongoTemplate.findAll(Vacina.class)).thenReturn(vacinaList);


        List<Vacina> result = vacinaRepository.findAll();


        assertEquals(vacinaList, result);

    }

=======
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test")
class VacinaRepositoryTest {
/*
    @Autowired
    private VacinaRepository vacinaRepository;

    @Mock
    private Vacina vacina;

    @Test
    void findVacinaComSucesso() {
        Vacina vacina = new Vacina(
                "Coronavac",
                "CR210-21",
                LocalDate.of(2022,12,29),
                2,
                14);
        vacinaRepository.save(vacina);
        Vacina foundVacina = vacinaRepository.findById(vacina.getId()).orElse(null);
        assertNotNull(foundVacina);
        assertEquals(vacina.getId(), foundVacina.getId());
    }

    @Test
    void findVacinaSemSucesso() {
        // Execução
        Vacina foundVacina = vacinaRepository.findById("id_inexistente").orElse(null);

        // Verificação
        assertNull(foundVacina);
    }

    @Test
    void listarVacinasComSucesso() {
        // Configuração
        Vacina vacina1 = new Vacina("Coronavac", "Sinovac", 2, 14);
        Vacina vacina2 = new Vacina("AstraZeneca", "Oxford", 2, 12);
        vacinaRepository.save(vacina1);
        vacinaRepository.save(vacina2);

        // Execução
        List<Vacina> vacinas = vacinaRepository.findAll();

        // Verificação
        assertNotNull(vacinas);
        assertTrue(vacinas.size() >= 2);
    }

    @Test
    void listarVacinasSemSucesso() {
        // Configuração
        vacinaRepository.deleteAll();

        // Execução
        List<Vacina> vacinas = vacinaRepository.findAll();

        // Verificação
        assertTrue(vacinas.isEmpty());
    }*/
>>>>>>> origin/develop
}