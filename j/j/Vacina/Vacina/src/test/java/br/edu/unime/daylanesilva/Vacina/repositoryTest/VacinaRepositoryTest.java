package br.edu.unime.daylanesilva.Vacina.repositoryTest;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
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
}