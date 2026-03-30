package Exercicios7_12;

import Utilidades.DoubleUtil;
import Utilidades.Erros.SenhaIncorretaException;

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
    private final String senha;
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
    public boolean autenticar(String senha) throws SenhaIncorretaException {
        if (senha.equals(this.senha)){
            return true;
        }
        throw new SenhaIncorretaException("Senha incorreta");
    }
}
