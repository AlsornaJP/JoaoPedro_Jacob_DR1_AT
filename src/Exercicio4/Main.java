package Exercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o nome do aluno");
        String nome = scan.nextLine();

        System.out.println("Insira o número da matricula");
        String matricula = scan.nextLine();

        System.out.println("Insira a primeira nota");
        double nota1 = scan.nextDouble();
        System.out.println("Insira a segunda nota");
        double nota2 = scan.nextDouble();
        System.out.println("Insira a terceira nota");
        double nota3 = scan.nextDouble();

        Aluno aluno= new Aluno(nome, matricula, nota1, nota2, nota3);
        aluno.verificarAprovacao();
    }
}
