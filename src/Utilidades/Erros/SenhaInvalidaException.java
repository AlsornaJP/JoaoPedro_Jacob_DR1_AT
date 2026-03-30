package Utilidades.Erros;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException(String m){
        super(m);
    }
}
