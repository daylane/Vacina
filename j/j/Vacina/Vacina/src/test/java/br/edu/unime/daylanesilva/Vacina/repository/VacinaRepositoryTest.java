package br.edu.unime.daylanesilva.Vacina.repository;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.text.html.parser.Entity;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test")
class VacinaRepositoryTest {


    private Vacina registrarVacina(Vacina vacina){
        Vacina novaVacina = new Vacina(vacina);
    }
    @Test
    void findVacinaComSucesso() {
    }

    @Test
    void listarVacinas() {
    }

    @Test
    void findById() {
    }
}