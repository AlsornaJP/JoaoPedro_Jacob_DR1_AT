package Exercicio2;

public class Funcionario {

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    private String nome;
    private double salario;

    public String getNome() {
        return nome;
    }

    public double calcularSalarioAnual(){
        return Double.parseDouble(String.format("%.2f", salario* 12));
    }

    public double calcularIR() {
        double salarioAnual = calcularSalarioAnual();

        if (salarioAnual <= 22_847.76) {
            return 0.00;
        } else if (salarioAnual >= 45_012.61) {
            return Double.parseDouble(String.format("%.2f",salarioAnual * 0.275));
        } else if (salarioAnual >= 33_919.81) {
            return Double.parseDouble(String.format("%.2f",salarioAnual * 0.15));
        } else {
            return Double.parseDouble(String.format("%.2f",salarioAnual * 0.075));
        }
    }
}
