package br.edu.unime.daylanesilva.Vacina.serviceTest;

import br.edu.unime.daylanesilva.Vacina.entity.Vacina;
import br.edu.unime.daylanesilva.Vacina.exception.BusinessException;
import br.edu.unime.daylanesilva.Vacina.repository.VacinaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;


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

        assertEquals(Optional.ofNullable(vacina), vacina);
        verify(vacinaRepository).findById(vacina.getId());
        verifyNoMoreInteractions(vacinaRepository);

    }

    @Test
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
    void deletarVacinaComSucesso() {
        when(vacinaRepository.findById(vacina.getId())).thenReturn(Optional.ofNullable(vacina));
        vacinaService.deletarVacina(String.valueOf(vacina.getId()));
        verify(vacinaRepository).deleteById(vacina.getId());
        verifyNoMoreInteractions(vacinaRepository);
    }
}
