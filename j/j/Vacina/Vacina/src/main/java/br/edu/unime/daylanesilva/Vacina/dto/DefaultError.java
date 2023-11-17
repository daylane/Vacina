package br.edu.unime.daylanesilva.Vacina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultError {
    private String code;
    private String message;

}
