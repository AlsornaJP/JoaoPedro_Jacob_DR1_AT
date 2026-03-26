package Exercicio2;

import Utilidades.DoubleUtil;

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
        return DoubleUtil.truncarDouble(salario * 12,2);
    }

    public double calcularIR() {
        double salarioAnual = calcularSalarioAnual();

        if (salarioAnual <= 22_847.76) {
            return 0.00;
        } else if (salarioAnual >= 45_012.61) {
            return DoubleUtil.truncarDouble(salarioAnual * 0.275,2);
        } else if (salarioAnual >= 33_919.81) {
            return DoubleUtil.truncarDouble(salarioAnual * 0.15,2);
        } else {
            return DoubleUtil.truncarDouble(salarioAnual * 0.075,2);
        }
    }
}