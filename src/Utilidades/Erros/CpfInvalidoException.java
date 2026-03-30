package Utilidades.Erros;

public class CpfInvalidoException extends RuntimeException{
    public CpfInvalidoException(String m){
        super(m);
    }
}