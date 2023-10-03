package br.edu.unime.daylanesilva.Vacina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String sexo;
    private EnderecoPaciente endereco;
    private List<String> contatos;
}
