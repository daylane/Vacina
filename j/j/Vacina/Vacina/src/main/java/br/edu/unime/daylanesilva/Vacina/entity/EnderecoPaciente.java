package br.edu.unime.daylanesilva.Vacina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPaciente {
    @NotEmpty(message = "O logradouro não pode está em branco!")
    private String logradouro;
    @NotEmpty(message = "O número da residência não pode está em branco!")
    private String numero;
    @NotEmpty(message = "O Bairro em endereço não pode está em branco!")
    private String bairro;
    @NotEmpty(message = "O Município não pode está em branco!")
    private String municipio;
    @NotEmpty(message = "O CEP não pode está em branco!")
    private String cep;
    @NotEmpty(message = "O Estado pode está em branco!")
    private String estado;

}
