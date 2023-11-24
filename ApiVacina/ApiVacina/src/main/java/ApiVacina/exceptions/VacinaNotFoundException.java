package ApiVacina.exceptions;

public class VacinaNotFoundException extends Exception{
    public VacinaNotFoundException() {

        super("vacina não encontrada");
    }
}
