package br.edu.unime.daylanesilva.Vacina.exceptions;

public class ResourceNotFoundException extends Throwable {
    public ResourceNotFoundException() {
        super("Vacina não encontrada na Base de Dados");
    }
}
