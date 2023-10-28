package br.edu.unime.daylanesilva.Vacina.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vacina {

    @Id
    private String id;
    @NotEmpty(message = "O fabricante não foi informado!")
    private String fabricante;
    @NotEmpty(message = "O lote não foi informado!")
    private String lote;
    @NotEmpty(message = "A data de validade não foi informada!")
    private LocalDate dataValidade;
    @NotNull(message = "O número de doses não foi informado!")
    private int numeroDoses;
    @NotNull(message = "O intervalo mínimo entre doses em dias da vacina não foi informado! OBS: Intervalo mínimo válido é 01 dia ou superior.")
    private int intervaloMinimoEntreDoses;

    public Vacina (String fabricante, String lote, LocalDate dataValidade, int numeroDoses, int intervaloMinimoEntreDoses) {
        this.fabricante = fabricante;
        this.lote = lote;
        this.dataValidade = dataValidade;
        this.numeroDoses = numeroDoses;
        this.intervaloMinimoEntreDoses = intervaloMinimoEntreDoses;
    }

    public static Object builder() {
        return  null;
    }
}
