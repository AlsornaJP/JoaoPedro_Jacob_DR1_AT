package Exercicios7_12;

import Utilidades.DoubleUtil;
import Utilidades.Erros.SenhaIncorretaException;
import Utilidades.Erros.SenhaInvalidaException;
import java.util.List;

public class Gerente extends Funcionario implements Autenticavel{
    //Construtor
    //----------------
    public Gerente(String nome, String sobrenome, String cpf,  double salario, String senha) {
        if(senha == null || senha.trim().isEmpty()){
            throw new SenhaInvalidaException("A senha é inválida");
        }
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
            return DoubleUtil.truncarDouble(salario * 1.1, 2);
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
