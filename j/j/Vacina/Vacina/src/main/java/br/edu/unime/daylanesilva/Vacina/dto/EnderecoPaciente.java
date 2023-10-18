package br.edu.unime.daylanesilva.Vacina.dto;

import lombok.Data;

@Data
public class EnderecoPaciente {
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String municipio;
    private String estado;
}
