package br.edu.unime.daylanesilva.Vacina.controllerTest;

import br.edu.unime.daylanesilva.Vacina.controller.VacinaController;
import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
import br.edu.unime.daylanesilva.Vacina.serviceTest.VacinaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


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
    VacinaController vacinaController;



    private Vacina vacina;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vacinaController)
                .alwaysDo(print())
                .build();

    }


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
