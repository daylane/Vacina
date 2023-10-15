package br.edu.unime.daylanesilva.Vacina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @NotEmpty(message = "O nome do paciente não pode está em branco!")
    private String nome;
    @NotEmpty(message = "O sobrenome do paciente não pode está em branco!")
    private String sobrenome;
    @NotEmpty(message = "A data de nascimento do paciente não pode está em branco!")
    private LocalDate dataNascimento;
    @NotEmpty(message = "O nome do paciente não pode está em branco!")
    private String sexo;
    @NotEmpty(message = "O endereço do paciente não pode está em branco!")
    private EnderecoPaciente endereco;
    @NotEmpty(message =
            "O contato do paciente não pode está vazio!" +
            "Obs: Ao menos um meio de contato deve ser informado!")
    private List<String> contatos;
}
