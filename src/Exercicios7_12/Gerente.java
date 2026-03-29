package Exercicios7_12;

import Utilidades.DoubleUtil;

import java.util.List;

public class Gerente extends Funcionario implements Autenticavel{
    //Construtor
    //----------------
    public Gerente(String nome, String sobrenome, String cpf,  double salario, String senha) {
        super(nome, cpf, sobrenome, salario);
        this.senha = senha;
    }
    //Atributos
    //----------------
    private int vendasEquipe;
    protected final String senha;
    //Métodos
    //----------------
    public void calcularVendasEquipe(List<Vendedor> vendedores){
        vendasEquipe = 0;
        int vendasTotais = 0;
        for(Vendedor v : vendedores){
            vendasTotais += v.getVendas();
        }
        vendasEquipe = vendasTotais;
    }
    @Override
    public double calcularSalario() {
        if (vendasEquipe >= 100) {
            return DoubleUtil.truncarDouble(salario * 1.10, 2);
        }
        return salario;
    }

    @Override
    public boolean autenticar(String senha) {
        return senha.equals(this.senha);
    }
}
