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
@Builder
public class Vacina {
    private String id;

    @NotBlank(message = "Fabricante não pode estar em branco.")
    @NotNull(message = "Fabricante não pode estar em nulo.")
    @Size(min = 3, max = 100, message = "O Fabricante deve ter entre 3 a 100 digitos")
    private String fabricante;

    @NotBlank(message = "Lote não pode estar em branco!")
    @NotNull(message = "Lote não pode estar nulo!")
    @Size(min = 3, max = 100, message = "O Lote deve ter entre 3 a 100 digitos!")
    private String lote;

    @NotEmpty(message = "A data de validade não foi informada!")
    private LocalDate dataValidade;

    @NotNull(message = "O número de doses não foi informado!")
    private int numeroDoses;

    @NotNull(message = "O intervalo mínimo entre doses em dias da vacina não foi informado! OBS: Intervalo mínimo válido é 01 dia ou superior.")
    private int intervaloMinimoEntreDoses;


    public Vacina(VacinaDto vacinaDTO) {
        setFabricante(vacinaDTO.getFabricante());
        setLote(vacinaDTO.getLote());
        setDataValidade(vacinaDTO.getDataValidade());
        setNumeroDoses(vacinaDTO.getNumeroDoses());
        setIntervaloMinimoEntreDoses(vacinaDTO.getIntervaloMinimoEntreDoses());

    }
}
