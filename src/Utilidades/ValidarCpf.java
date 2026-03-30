package Utilidades;

public class ValidarCpf {
    public static boolean validar(String cpf){
        return cpf.matches("[0-9]{11}");
    }
}
