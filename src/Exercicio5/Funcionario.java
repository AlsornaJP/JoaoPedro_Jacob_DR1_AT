package Exercicio5;

abstract class Funcionario {

    public Funcionario(String nome, double salariobase) {
        this.nome = nome;
        this.salariobase = salariobase;
    }

    private String nome;
    private double salariobase;

    public double getSalariobase() {
        return salariobase;
    }

    public String getNome() {
        return nome;
    }
}
