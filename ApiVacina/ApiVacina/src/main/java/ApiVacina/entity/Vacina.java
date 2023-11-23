package ApiVacina.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vacinas")
public class Vacina {

    @Id
    private String id;
    @NotEmpty(message = "O fabricante da vacina não foi informado!")
    private String fabricante;
    @NotEmpty(message = "O lote da vacina não foi informado!")
    private String lote;
    @NotNull(message = "A data de validade da vacina não foi informada!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate dataValidade;
    @NotNull(message = "O número de doses da vacina não foi informado!")
    @Min(value = 1, message = "O número de doses da vacina deve ser maior que 0!")
    private int totalDoses;
    @Min(value = 1, message = "O intervalo mínimo entre doses em dias deve ser maior que 0!")
    private int intervaloAplicacao;

    public Vacina(String id, String fabricante, String lote, LocalDate dataValidade, int totalDoses, int intervaloAplicacao) {
        if(dataValidade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de validade deve ser no futuro.");
        }
            if (totalDoses <= 0 || intervaloAplicacao <= 0) {
                throw new IllegalArgumentException("O número de doses e o intervalo mínimo devem ser positivos.");
        }
        this.id = id;
        this.fabricante = fabricante;
        this.lote = lote;
        this.dataValidade = dataValidade;
        this.totalDoses = totalDoses;
        this.intervaloAplicacao = intervaloAplicacao;
    }


}
