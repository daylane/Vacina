package ApiVacina.entity;
import ApiVacina.dto.VacinaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacina {
    private String id;
    private String fabricante;
    private String vacina;
    private String lote;
    private LocalDate dataValidade;
    private int numeroDoses;
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
