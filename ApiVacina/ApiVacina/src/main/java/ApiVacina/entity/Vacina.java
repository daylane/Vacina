package ApiVacina.entity;
import ApiVacina.dto.VacinaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacina {
    private String id;
    @NotBlank(message = "Nome do fabricante não pode estar em branco.")
    private String fabricante;
    @NotBlank(message = "Nome da vacina não pode estar em branco.")
    private String vacina;
    @NotBlank(message = "Nome do lote não pode estar em branco.")
    private String lote;
    private LocalDate dataValidade;
    @Min(value = 1, message = "O numero de doses deve ser maior ou igual a 1.")
    private int numeroDoses;
    @Min(value = 1, message = "O Intervalo minimo entre doses deve ser maior ou igual a 1.")
    private int intervaloMinimoEntreDoses;


   /* public Vacina(VacinaDto vacinaDTO) {
        setVacina(vacinaDTO.getVacina());
        setFabricante(vacinaDTO.getFabricante());
        setLote(vacinaDTO.getLote());
        setDataValidade(vacinaDTO.getDataValidade());
        setNumeroDoses(vacinaDTO.getNumeroDoses());
        setIntervaloMinimoEntreDoses(vacinaDTO.getIntervaloMinimoEntreDoses());

    }*/
}
