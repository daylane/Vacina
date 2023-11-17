package br.edu.unime.daylanesilva.Vacina.controllerTest;

import br.edu.unime.daylanesilva.Vacina.dto.VacinaDTO;
import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.exception.VacinaNotFoundException;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
import br.edu.unime.daylanesilva.Vacina.serviceTest.VacinaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class VacinaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private VacinaService vacinaService;

    @MockBean
    private VacinaRepository vacinaRepository;

    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();


    private final Vacina vacina;

    public VacinaControllerTest(VacinaService vacinaService, VacinaRepository vacinaRepository, Vacina vacina) {
        this.vacinaService = vacinaService;
        this.vacinaRepository = vacinaRepository;
        this.vacina = vacina;
    }

    @Test
    @DisplayName("Deve ser possivel obter todos as vacinas cadrastadas")
    public void testeListarVAcinas() throws Exception {

        Vacina vacina1 = new Vacina();
        vacina1.setFabricante("StropsFarm");
        vacina1.setLote("AJS3211");
        vacina1.setDataValidade(LocalDate.of(2031,12,21));
        vacina1.setNumeroDoses(3);
        vacina1.setIntervaloMinimoEntreDoses(21);

        Vacina vacina2 = new Vacina();
        vacina2.setFabricante("NeoFarma");
        vacina2.setLote("FHD231MLD1");
        vacina2.setDataValidade(LocalDate.of(2023,12,8));
        vacina2.setNumeroDoses(2);
        vacina2.setIntervaloMinimoEntreDoses(30);

        List<Vacina> vacinas = Arrays.asList(vacina1, vacina2);

        when(VacinaService.listarVacinas()).thenReturn(vacinas);

        mockMvc.perform(MockMvcRequestBuilders.get("/Vacinas"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value(vacina1.getFabricante()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sobrenome").value(vacina1.getLote()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sexo").value(vacina1.getDataValidade()));

        verify(vacinaService, times(1))
                .listarVacinas();
    }
    @Test
    @DisplayName("Deve retornar um array vazio quando busca não retornar vacinas")
    public void testObterListagemEmBranco() throws Exception{

        List<Vacina> vacinas = new ArrayList<>();

        when(VacinaService.listarVacinas()).thenReturn(vacinas);

        mockMvc.perform(MockMvcRequestBuilders.get("/Vacinas"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0));

                verify(vacinaService, times(1))
                        .listarVacinas();
    }
    @Test
    @DisplayName("Deve retornar uma vacina ao buscar pelo id")
    public void testeBuscarVacinaPorId() throws Exception {
        Vacina vacina1 = new Vacina();
        vacina1.setId("653d254a70793512735a8edf");
        vacina1.setFabricante("StropsFarm");
        vacina1.setLote("AJS3211");
        vacina1.setDataValidade(LocalDate.of(2031,12,21));
        vacina1.setNumeroDoses(3);
        vacina1.setIntervaloMinimoEntreDoses(21);
        when(vacinaService.findByid(vacina.getId())).thenReturn(Optional.of(vacina));

        mockMvc.perform(MockMvcRequestBuilders.get("/vacinas/"+vacina1.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fabricante").value(vacina.getFabricante()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lote").value(vacina.getLote()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dataValidade").value(vacina.getDataValidade().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeroDoses").value(vacina.getNumeroDoses()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.intervaloMinimoEntreDoses").value(vacina.getIntervaloMinimoEntreDoses()));


        verify(vacinaService, times(1)).findByid(vacina.getId());
        verifyNoMoreInteractions(vacinaService);

    }

    @Test
    @DisplayName("Deve retornar um Exception ao buscar um id inexistente")
    void testeRetornarExceptionDevidoIdInexistente() throws Exception {
        String id = "12345";

        Mockito.when(vacinaService.findByid(id)).thenAnswer(invocationOnMock -> {throw new Exception("Erro na requisição da vacina");
        });

        mockMvc.perform(MockMvcRequestBuilders.get("/Vacinas/" + id))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verify(vacinaService, times(1)).findByid(id);
    }

    @Test
    @DisplayName("Deve atualizar uma vacina")
    void testeAtualizarVacina() throws Exception, VacinaNotFoundException {
        Vacina vacina1 = new Vacina();
        vacina1.setId("12345");
        vacina1.setFabricante("NeoQuimica");
        vacina1.setLote("COR123th145");
        vacina1.setDataValidade(LocalDate.of(2023, 12, 25));
        vacina1.setNumeroDoses(2);
        vacina1.setIntervaloMinimoEntreDoses(15);

        Mockito.when(vacinaService.atualizarVacina(Mockito.any(VacinaDTO.class), Mockito.anyString())).thenReturn(vacina1);


        mockMvc.perform(MockMvcRequestBuilders.put("/Vacinas/" + vacina1.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vacina1)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fabricante").value(vacina1.getFabricante()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lote").value(vacina1.getLote()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dataValidade").value(vacina1.getDataValidade().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeroDoses").value(vacina1.getNumeroDoses()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.intervaloMinimoEntreDoses").value(vacina1.getIntervaloMinimoEntreDoses()));

        verify(vacinaService, times(1)).atualizarVacina(Mockito.any(VacinaDTO.class),Mockito.eq(vacina1.getId()));
    }

    @Test
    @DisplayName("Deve lançar exceção ao atualizar paciente com ID inexistente")
    public void testAtualizarPacienteIdInexistente() throws Exception {
        // Arrange
        Vacina novaVacina = new Vacina();
      novaVacina.setFabricante("NeoQuimica");
      novaVacina.setLote("GFL43-FD");
      novaVacina.setDataValidade(LocalDate.of(2023,12,31));
      novaVacina.setNumeroDoses(5);
      novaVacina.setIntervaloMinimoEntreDoses(20);

        when(vacinaService.atualizarVacina(any(), any())).thenThrow(new VacinaNotFoundException("Vacina não encontrado"));

        // Act e Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/Vacinas/IDInexistente")
                        .content(asJsonString(novaVacina))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json("{\"message\":\"Vacina não encontrada com o ID: IDInexistente\"}"));
    }
    private String asJsonString(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    @Test
    @DisplayName("Deve excluir uma vacina pelo id")
    void testeDeletarVacinaPeloId() throws Exception {
        Vacina vacina1 = new Vacina();
        vacina1.setId("12345");
        vacina1.setFabricante("Probiotica");
        vacina1.setLote("PNT12R3");
        vacina1.setDataValidade(LocalDate.of(2023, 12, 25));
        vacina1.setNumeroDoses(2);
        vacina1.setIntervaloMinimoEntreDoses(15);

        doNothing().when(vacinaService).deletarVacina(vacina1.getId());

        mockMvc.perform(MockMvcRequestBuilders.delete("/Vacinas/" + vacina.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        verify(vacinaService, times(1)).deletarVacina(vacina1.getId());
    }

    @Test
    @DisplayName("Deve lançar Exception quando id do paciente que for tentado excluir não existir")
    void testeDeletarVacinaSemSucesso() throws Exception {
        String id = "12345";

        doThrow(new Exception()).when(vacinaService).deletarVacina(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/Vacinas/" + id))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verify(vacinaService, times(1)).deletarVacina(id);
    }

}
