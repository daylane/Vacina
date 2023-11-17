package br.edu.unime.daylanesilva.Vacina.serviceTest;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.exception.BusinessException;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
<<<<<<< HEAD
import org.junit.jupiter.api.DisplayName;
=======
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
>>>>>>> origin/develop
import org.junit.jupiter.api.Test;



import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;
=======
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;


>>>>>>> origin/develop
import java.util.Optional;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class VacinaServiceTest {

    @InjectMocks
    VacinaService vacinaService;

    @Mock
    VacinaRepository vacinaRepository;

<<<<<<< HEAD
    @MockBean
    Vacina vacina;
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Deve retornar todos os pacientes cadastrados")
    void testelistarTodasVacinas(){
        List<Vacina> vacinasMock = new ArrayList<>();
        when(vacinaRepository.findAll()).thenReturn(vacinasMock);

        List<Vacina> vacinas = vacinaService.listarVacinas();
        assertThat(vacinas).isEqualTo(vacinasMock);
        verifyNoMoreInteractions(vacinaRepository);
    }
    @Test
    @DisplayName("Não deve retornar as vacinas cadastradas")
    void testeErrorAolistarTodasVacinas(){
        List<Vacina> vacinasMock = new ArrayList<>();
        when(vacinaRepository.findAll()).thenReturn(vacinasMock);

        List<Vacina> vacinas = vacinaService.listarVacinas();
        assertThat(vacinas).isNotEqualTo(vacinasMock);
        verifyNoInteractions(vacinaRepository);
    }

    @Test
    @DisplayName("Deve registrar uma nova vacina")
    void testRegistrarVacina(){
        Vacina vacina1 = new Vacina();
        when(vacinaRepository.insert((Vacina) any())).thenReturn(vacina1);

        Vacina vacina2 = vacinaService.registrarVacina(new Vacina());

        assertThat(vacina2).isEqualTo(vacina1);
        verifyNoMoreInteractions(vacinaRepository);
    }

    @Test
    @DisplayName("Não deve registrar uma nova vacina")
    void testErrorAoRegistrarVacina(){
        Vacina vacina1 = new Vacina();
        when(vacinaRepository.insert((Vacina) any())).thenReturn(vacina1);

        Vacina vacina2 = vacinaService.registrarVacina(new Vacina());

        assertThat(vacina2).isEqualTo(vacina1);
        verifyNoInteractions(vacinaRepository);
    }

    @Test
    @DisplayName("Deve buscar um vacina pelo ID solicitado")
    void testebuscarVacinaPorIdComSucesso() {
        when(vacinaRepository.findById(vacina.getId())).thenReturn(Optional.ofNullable(vacina));
        Optional<Vacina> vacinas = vacinaService.findByid(String.valueOf(vacina));
=======
    Vacina vacina;

    @BeforeEach
    public void setUp(){
        vacina = new Vacina(
                "Strepos",
                "KA092-B21",
                LocalDate.of(2023,1,14),
                3,
                14
        );
    }

    @Test
    void listarTodasVacinas(){

        Assertions.assertEquals(vacina, vacinaService.listarVacinas());
    }

    @Test
    void buscarVacinaPorIdComSucesso() {
        when(vacinaRepository.findById(vacina.getId())).thenReturn(Optional.ofNullable(vacina));
        Optional<Vacina> vacinas = vacinaService.buscarVacina(String.valueOf(vacina));
>>>>>>> origin/develop

        assertEquals(Optional.ofNullable(vacina), vacina);
        verify(vacinaRepository).findById(vacina.getId());
        verifyNoMoreInteractions(vacinaRepository);

    }

    @Test
<<<<<<< HEAD
    @DisplayName("Não deve acionar o repository em falha de requisição por parte do usuario")
    void testenaoDeveAcionarRepositoryEmCasoFalha() {
        final BusinessException e = assertThrows(BusinessException.class, () -> {
            vacinaService.findByid(null);
=======
    void naoDeveAcionarRepositoryEmCasoFalha() {
        final BusinessException e = assertThrows(BusinessException.class, () -> {
            vacinaService.buscarVacina(null);
>>>>>>> origin/develop
        });
        assertThat(e).isNotNull();
        assertThat(e.getMessage()).isEqualTo("Erro ao buscar vacina pelo ID = null");
        assertThat(e.getCause()).isNotNull();
        assertThat(e.getCause().getMessage()).isEqualTo("Id é obrigatório!");
        verifyNoInteractions(vacinaRepository);
    }

    @Test
<<<<<<< HEAD
    @DisplayName("Deve lançar uma Exception em caso de falha do repository")
    void testeacionarExceptionNaFalhaRepository() {
        when(vacinaRepository.findById(vacina.getId()))
                .thenThrow(new RuntimeException(("Falha ao buscar vacina pelo ID!")));
        final BusinessException e = assertThrows(BusinessException.class, () -> {
            vacinaService.findByid(vacina.getId());
=======
    void acionarExceptionNaFalhaRepository() {
        when(vacinaRepository.findById(vacina.getId()))
                .thenThrow(new RuntimeException(("Falha ao buscar vacina pelo ID!")));
        final BusinessException e = assertThrows(BusinessException.class, () -> {
            vacinaService.buscarVacina(vacina.getId());
>>>>>>> origin/develop
        });

        assertThat(e.getMessage()).isEqualTo(format("Erro ao buscar vacina pelo ID = %s", vacina.getId()));
        assertThat(e.getCause().getClass()).isEqualTo(RuntimeException.class);
        assertThat(e.getCause().getMessage()).isEqualTo("Falha ao buscar vacina pelo ID!");
        verify(vacinaRepository).findById(vacina.getId());
        verifyNoMoreInteractions(vacinaRepository);

    }
    @Test
<<<<<<< HEAD
    @DisplayName("Deve ser possível remover uma vacina existente")
    void testedeletarVacinaComSucesso() {
        Vacina vacina1 = new Vacina();
        vacina1.setId("653d254a70793512735a8edf");

        when(vacinaRepository.findById(vacina.getId())).thenReturn(Optional.of(vacina));

        vacinaService.deletarVacina(String.valueOf(vacina.getId()));

        verify(vacinaRepository).deleteById(vacina.getId());

        verifyNoMoreInteractions(vacinaRepository);
    }

    @Test
    @DisplayName("Não deve ser possível remover uma vacina existente")
    void testeDeletarVacinaSemScesso() {
        Vacina vacina1 = new Vacina();
        vacina1.setId("12345");

        when(vacinaRepository.findById(vacina.getId())).thenReturn(Optional.of(vacina));

        vacinaService.deletarVacina(String.valueOf(vacina.getId()));

        verify(vacinaRepository).deleteById(vacina.getId());

        verifyNoInteractions(vacinaRepository);
    }
=======
    void deletarVacinaComSucesso() {
        when(vacinaRepository.findById(vacina.getId())).thenReturn(Optional.ofNullable(vacina));
        vacinaService.deletarVacina(String.valueOf(vacina.getId()));
        verify(vacinaRepository).deleteById(vacina.getId());
        verifyNoMoreInteractions(vacinaRepository);
    }
>>>>>>> origin/develop
}
