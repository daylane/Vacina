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

    @Test
    void findVacinaComSucesso() {
    }
    @Test
    void findVacinaSemSucesso() {
    }


    @Test
    void listarVacinasComSucesso() {
    }

    @Test
    void listarVacinasSemSucesso() {
    }

}