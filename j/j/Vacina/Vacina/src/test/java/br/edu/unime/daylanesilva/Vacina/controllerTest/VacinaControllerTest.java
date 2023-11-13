package br.edu.unime.daylanesilva.Vacina.controllerTest;

import br.edu.unime.daylanesilva.Vacina.controller.VacinaController;
import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.service.VacinaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VacinaControllerTest {

    @InjectMocks
    private VacinaController vacinaController;

    @Mock
    private VacinaService vacinaService;

    @Autowired
    private MockMvc mockMvc;

    private Vacina vacina;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vacinaController)
                .alwaysDo(print())
                .build();

    }
/*    @Test
    public void testRegistrarVacina() throws Exception {
        // Dados da vacina para o teste
        Vacina vacina = new Vacina();
        vacina.setFabricante("Pfizer");
        vacina.setLote("PF12345");
        vacina.setDataValidade(LocalDate.parse("2023-12-31"));
        vacina.setNumeroDoses(2);
        vacina.setIntervaloMinimoEntreDoses(21);


        when(vacinaService.registrarVacina(Mockito.any(Vacina.class))).thenReturn(vacina);
        ResultActions perform = mockMvc.perform(post("/vacinas/registrar-vacina")
                .contentType(MediaType.APPLICATION_JSON)
                .andExpect(content().json("{\"fabricante\":\"Pfizer\",\"lote\":\"PF12345\",\"dataValidade\":\"2023-12-31\",\"numeroDoses\":2,\"intervaloMinimoEntreDoses\":21}"))
                .andExpect(status().isCreated()));
    }*/

    @Test
    public void testBuscarVacinaPorId() throws Exception {
        Vacina vacina = new Vacina();
        when(vacinaService.buscarVacina(vacina.getId())).thenReturn(Optional.of(vacina));

        mockMvc.perform(get("/testes-junit5/vacinas/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // Adicione mais métodos de teste conforme necessário...
}
