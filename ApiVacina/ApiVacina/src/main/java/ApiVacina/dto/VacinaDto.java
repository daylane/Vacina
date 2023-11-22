package ApiVacina.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinaDto {

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
    private int total_de_doses;
    @Min(value = 1, message = "O intervalo mínimo entre doses em dias deve ser maior que 0!")
    private int intervalo_entre_doses;

    public VacinaDto() {
    }
}
