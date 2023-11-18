package br.edu.unime.daylanesilva.Vacina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinaDTO {

   @Id
    private String Id;
   private String nome;
    private String fabricante;
    private String lote;
    private LocalDate dataValidade;
    private int numeroDoses;
    private int intervaloMinimoEntreDoses;


}
