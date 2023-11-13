package br.edu.unime.daylanesilva.Vacina.exception;

public class vacinaNotFoundException extends RuntimeException  {
    public vacinaNotFoundException(String mensagem) {
        super(mensagem);
    }
}
