package Exercicios7_12;

import Utilidades.DoubleUtil;

public class Vendedor extends Funcionario {
    //Construtor
    //----------------
    public Vendedor(String nome, String sobrenome, String cpf, double salario) {
        super(nome, cpf, sobrenome, salario);
    }
    //Atributos
    //----------------
    private int vendas = 0;
    //Getters
    //----------------
    public int getVendas() {return vendas;}
    //Métodos
    //----------------
    public void registrarVenda(){vendas++;}
    @Override
    public double calcularSalario() {
        var bonus = salario * 0.02;
        var salarioFinal = DoubleUtil.truncarDouble(salario + (bonus * vendas), 2);
        vendas = 0;
        return salarioFinal;
    }
}
