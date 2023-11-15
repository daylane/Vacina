package br.edu.unime.daylanesilva.Vacina.controllerTest;

import br.edu.unime.daylanesilva.Vacina.controller.VacinaController;
import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
import br.edu.unime.daylanesilva.Vacina.service.VacinaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class VacinaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private VacinaService vacinaService;

    @MockBean
    private VacinaRepository vacinaRepository;

    @InjectMocks
    private VacinaController vacinaController;



    private Vacina vacina;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vacinaController)
                .alwaysDo(print())
                .build();

    }

   /* @Test
    @DisplayName("Deve retornar uma lista de vacinas cadastradas")
    void listarTodasVacinasNoBD() throws Exception {
        Vacina vacina1  = new Vacina();
        vacina1.setFabricante("Pfizer-BioNTech");
        vacina1.setLote("PB321L001");
        vacina1.setDataValidade(LocalDate.of(2012, 3, 12));
        vacina1.setNumeroDoses(2);
        vacina1.setIntervaloMinimoEntreDoses(21);

        Vacina vacina2 = new Vacina();
        vacina2.setFabricante("AstraZeneca");
        vacina2.setLote("AZ153LT23-0");
        vacina2.setDataValidade(LocalDate.of(2014, 9, 21));
        vacina2.setNumeroDoses(1);
        vacina2.setIntervaloMinimoEntreDoses(0);

        List<Vacina> listaVacinas = Arrays.asList(vacina1, vacina2);

        Mockito.when(vacinaService.listarVacinas()).thenReturn(listaVacinas);

        mockMvc.perform(MockMvcRequestBuilders.get("/vacinas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fabricante").value(vacina1.getFabricante()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lote").value(vacina1.getLote()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dataValidade.length()").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].numeroDoses").value(vacina1.getNumeroDoses()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].intervaloMIninoentreDoses").value(vacina1.getIntervaloMinimoEntreDoses()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fabricante").value(vacina2.getFabricante()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lote").value(vacina2.getLote()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dataValidade.length()").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].numeroDoses").value(vacina2.getNumeroDoses()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].intervaloMinimoEntreDoses").value(vacina2.getIntervaloMinimoEntreDoses()));

        verify(vacinaService, times(1)).listarVacinas();
        verifyNoMoreInteractions(vacinaService);
    }*/
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

        mockMvc.perform(get("/vacinas/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        verify(vacinaService, times(1)).buscarVacina(vacina.getId());
        verifyNoMoreInteractions(vacinaService);

    }


}
