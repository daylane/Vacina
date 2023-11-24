package ApiVacina.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacina {
    @Id
    private String id;
    @NotBlank(message = "Nome do fabricante não pode estar em branco.")
    private String fabricante;
    @NotBlank(message = "Nome da vacina não pode estar em branco.")
    private String vacina;
    @NotBlank(message = "Nome do lote não pode estar em branco.")
    private String lote;
    @NotNull(message = "A data de validade da vacina não pode está em branco e o valor da data não pode ser no passado")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @FutureOrPresent
    private LocalDate dataValidade;
    @NotNull(message = "O número de doses da vacina não pode está em branco")
    @Min(value = 1, message = "O numero de doses deve ser maior ou igual a 1.")
    private int numeroDoses;
    @Min(value = 1, message = "O Intervalo minimo entre doses deve ser maior ou igual a 1, no caso de doses unicas: informe 0.")
    private int intervaloMinimoEntreDoses;

    public Vacina(String fabricante, String vacina, String lote, LocalDate dataValidade, int numeroDoses, int intervaloMinimoEntreDoses) {

        this.fabricante = fabricante;
        this.vacina = vacina;
        this.lote = lote;
        this.dataValidade = dataValidade;
        this.numeroDoses = numeroDoses;
        this.intervaloMinimoEntreDoses = intervaloMinimoEntreDoses;
    }


}
