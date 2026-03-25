package Exercicio2;

import java.util.Scanner;

public class CalculadoraIR {
    static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String nome = scan.nextLine();
        double salario = scan.nextDouble();

        Funcionario func = new Funcionario(nome, salario);

    }

}
