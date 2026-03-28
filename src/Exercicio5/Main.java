package Exercicio5;

public class Main {
    public static void main(String[] args){
        Gerente gerente = new Gerente("João", 5000);
        Estagario estagiario = new Estagario("Pedro", 2000);

        System.out.println("Salário do gerente:");
        gerente.mostrarSalario();
        System.out.println("Salário do estagiario:");
        estagiario.mostrarSalario();
    }
}
