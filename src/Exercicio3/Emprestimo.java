package Exercicio3;

import java.util.Scanner;

public class Emprestimo {
    static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("insira seu nome:");
        String nome = scan.nextLine();

        System.out.println("insira o valor do empréstimo:");
        double emprestimo = scan.nextDouble();

        System.out.println("Em quantos meses deseja parcelar? (min. 6, max. 48");
        int parcelas = scan.nextInt();
        while(parcelas < 6 || parcelas > 48 ){
            System.out.println("Valor inválido");
            parcelas = scan.nextInt();
        }
        double valorParcela = (emprestimo/parcelas) + (emprestimo * 0.03);
        double valorTotal = valorParcela * parcelas;

        System.out.println("Valor total: " + valorTotal +"\tValor de cada parcela: " + valorParcela);
    }
}
