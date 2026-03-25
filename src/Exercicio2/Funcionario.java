package Exercicio2;

public class Funcionario {

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    private String nome;
    private double salario;

    public double calcularSalarioAnual(){
        return salario * 12;
    }

//    public double calcularIR(){
//        var salarioAnual = calcularSalarioAnual();
//
//    }
}
