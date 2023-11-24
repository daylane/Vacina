package ApiVacina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinaDto {
    private String fabricante;
    private String vacina;
    private int numeroDoses;
    private int intervaloMinimoEntreDoses;

}
