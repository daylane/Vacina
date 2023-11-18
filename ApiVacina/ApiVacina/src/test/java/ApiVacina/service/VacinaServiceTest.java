package ApiVacina.service;

import ApiVacina.Repository.VacinaRepository;
import ApiVacina.entity.Vacina;
import ApiVacina.entityTest.VacinaTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VacinaServiceTest {
    @InjectMocks
    VacinaService vacinaService;

    @Mock
    VacinaRepository vacinaRepository;

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
        Vacina vacina;

      /*  @BeforeEach
        public void setUp(){
            vacina = new VacinaTest(
                    "Strepos",
                    "KA092-B21",
                    LocalDate.of(2023,1,14),
                    3,
                    14
            );
        }*/

     /*   @Test
        void listarTodasVacinas(){

            Assertions.assertEquals(vacina, vacinaService.listarVacinas());
        }

        @Test
        void buscarVacinaPorIdComSucesso() {
            when(vacinaRepository.findById(vacina.getId())).thenReturn(Optional.ofNullable(vacina));
            Optional<Vacina> vacinas = vacinaService.buscarVacina(String.valueOf(vacina));

            assertEquals(Optional.ofNullable(vacina), vacina);
            verify(vacinaRepository).findById(vacina.getId());
            verifyNoMoreInteractions(vacinaRepository);

        }

        @Test
        @DisplayName("Não deve acionar o repository em falha de requisição por parte do usuario")
        void testenaoDeveAcionarRepositoryEmCasoFalha() {
            final BusinessException e = assertThrows(BusinessException.class, () -> {
                vacinaService.findByid(null);
                void naoDeveAcionarRepositoryEmCasoFalha() {
                    final BusinessException e = assertThrows(BusinessException.class, () -> {
                        vacinaService.buscarVacina(null);
                    });
                    assertThat(e).isNotNull();
                    assertThat(e.getMessage()).isEqualTo("Erro ao buscar vacina pelo ID = null");
                    assertThat(e.getCause()).isNotNull();
                    assertThat(e.getCause().getMessage()).isEqualTo("Id é obrigatório!");
                    verifyNoInteractions(vacinaRepository);
                }

                @Test
                @DisplayName("Deve lançar uma Exception em caso de falha do repository")
                void testeacionarExceptionNaFalhaRepository() {
                    when(vacinaRepository.findById(vacina.getId()))
                            .thenThrow(new RuntimeException(("Falha ao buscar vacina pelo ID!")));
                    final BusinessException e = assertThrows(BusinessException.class, () -> {
                        vacinaService.findByid(vacina.getId());

                        void acionarExceptionNaFalhaRepository() {
                            when(vacinaRepository.findById(vacina.getId()))
                                    .thenThrow(new RuntimeException(("Falha ao buscar vacina pelo ID!")));
                            final BusinessException e = assertThrows(BusinessException.class, () -> {
                                vacinaService.buscarVacina(vacina.getId());

                            });

                            assertThat(e.getMessage()).isEqualTo(format("Erro ao buscar vacina pelo ID = %s", vacina.getId()));
                            assertThat(e.getCause().getClass()).isEqualTo(RuntimeException.class);
                            assertThat(e.getCause().getMessage()).isEqualTo("Falha ao buscar vacina pelo ID!");
                            verify(vacinaRepository).findById(vacina.getId());
                            verifyNoMoreInteractions(vacinaRepository);

                        }
                        @Test
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

                        void deletarVacinaComSucesso() {
                            when(vacinaRepository.findById(vacina.getId())).thenReturn(Optional.ofNullable(vacina));
                            vacinaService.deletarVacina(String.valueOf(vacina.getId()));
                            verify(vacinaRepository).deleteById(vacina.getId());
                            verifyNoMoreInteractions(vacinaRepository);
                        }*/
    }

}
