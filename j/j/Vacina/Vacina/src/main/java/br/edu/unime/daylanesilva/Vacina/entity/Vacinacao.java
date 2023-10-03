package br.edu.unime.daylanesilva.Vacina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacinacao {

    private LocalDate dataVacinacao;
    private Paciente paciente;
    private Vacina vacina;
    private int dose;
    private ProfissionalSaude profissionalSaude;
}
