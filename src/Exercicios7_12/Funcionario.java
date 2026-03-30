package Exercicios7_12;

import Utilidades.Erros.CpfInvalidoException;
import Utilidades.ValidarCpf;

import java.time.LocalDate;

public abstract class Funcionario {
    //Construtor
    //----------------
    public Funcionario(String nome, String cpf, String sobrenome, double salario) {
        if(salario<0){
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        if(cpf == null || !ValidarCpf.validar(cpf)){
            throw new CpfInvalidoException("CPF inválido. Digite apenas números, sem pontos ou hífen");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.dataAdmissao = LocalDate.now();
    }
    //Atributos
    //----------------
    private String nome;
    private String sobrenome;
    private final String cpf;
    protected double salario;
    private final LocalDate dataAdmissao;
    //Getters
    //----------------
    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }
    public LocalDate getDataAdmissao() {return dataAdmissao;}
    public final String getCpf() {return cpf;}
    public double getSalario() {return salario;}
    //Setters
    //----------------
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    //Métodos
    //----------------
    public abstract double calcularSalario();

}
