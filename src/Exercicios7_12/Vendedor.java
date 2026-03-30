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
    public void reiniciarVendas(){vendas = 0;}
    @Override
    public double calcularSalario() {
        var bonus = salario * 0.02;
        return DoubleUtil.truncarDouble(salario + (bonus * vendas), 2);
    }
}
