package br.edu.unime.daylanesilva.Vacina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPaciente {
    private String logradouro;
    private String numero;
    private String bairro;
    private String municipio;
    private String cep;
    private String estado;

}
