package ApiVacina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinaDto {
    private String fabricante;
    private String vacina;
    private int total_de_doses;
    private int intervalo_entre_doses;

}
