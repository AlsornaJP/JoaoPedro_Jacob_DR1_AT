package Exercicio2;

import java.util.Scanner;

public class CalculadoraIR {
    static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("insira um nome para o funcionário");
        String nome = scan.nextLine();
        System.out.println("insira o salário do funcionário");
        double salario = scan.nextDouble();

        Funcionario func = new Funcionario(nome, salario);

        var salarioAnual = func.calcularSalarioAnual();
        var deducao = func.calcularIR();
        var salarioLiquido = salarioAnual - deducao;

        System.out.println("O valor do imposto de renda para " + func.getNome() + " é de " + deducao + "  reais, e o salário líquido é de " + salarioLiquido + " reais");
    }

}
