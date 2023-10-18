package br.edu.unime.daylanesilva.Vacina.dto;

import br.edu.unime.daylanesilva.Vacina.entity.EnderecoPaciente;
import lombok.Data;

@Data
public class Paciente {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
    private String sexo;
    private String contato;
    private EnderecoPaciente endereco;
}

