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
    @Id
    private String Id;
    private String fabricante;
    private String vacina;
    private String lote;
    private LocalDate dataValidade;
    private int numeroDoses;
    private int intervaloMinimoEntreDoses;

}
