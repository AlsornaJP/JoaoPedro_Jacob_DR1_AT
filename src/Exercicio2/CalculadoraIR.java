package Exercicio2;

import java.util.Scanner;

public class CalculadoraIR {
    static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("insira um nome para o funcionário");
        String nome = scan.nextLine();
        System.out.println("insira o salário do funcionário");
        double salario = scan.nextDouble();

        Cliente cliente = new Cliente(nome, salario);

        var salarioAnual = cliente.calcularSalarioAnual();
        var deducao = cliente.calcularIR();
        var salarioLiquido = salarioAnual - deducao;

        System.out.println("O valor do imposto de renda para " + cliente.getNome() + " é de " + deducao + "  reais, e o salário líquido é de " + salarioLiquido + " reais");
    }

}

