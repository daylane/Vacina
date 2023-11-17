package br.edu.unime.daylanesilva.Vacina.entityTest;

<<<<<<< HEAD
import br.edu.unime.daylanesilva.Vacina.dto.VacinaDTO;
import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacinaTest {

    @Test
    @DisplayName("Verifica funcionalidade do construtor da entidade Vacina")
    public void testVacinaConstructor() {

        VacinaDTO vacinaDTO = new VacinaDTO();
        vacinaDTO.setFabricante("Pfizer");
        vacinaDTO.setLote("ABC123");
        vacinaDTO.setDataValidade(LocalDate.of(2023,12,31));
        vacinaDTO.setNumeroDoses(2);
        vacinaDTO.setIntervaloMinimoEntreDoses(21);

        Vacina vacina = new Vacina(vacinaDTO);


        assertEquals(vacinaDTO.getFabricante(), vacina.getFabricante());
        assertEquals(vacinaDTO.getLote(), vacina.getLote());
        assertEquals(vacinaDTO.getDataValidade(), vacina.getDataValidade());
        assertEquals(vacinaDTO.getNumeroDoses(), vacina.getNumeroDoses());
        assertEquals(vacinaDTO.getIntervaloMinimoEntreDoses(), vacina.getIntervaloMinimoEntreDoses());
    }
=======

class VacinaTest {

>>>>>>> origin/develop
}