package Exercicios7_12;

public abstract class Funcionario {
    //Construtor
    //----------------
    public Funcionario(String nome, String cpf, String sobrenome, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
        this.salario = salario;
    }
    //Atributos
    //----------------
    private String nome;
    private String sobrenome;
    private String cpf;
    protected double salario;
    //Getters
    //----------------
    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }
    public final String getCpf() {return cpf;}
    public double getSalario() {return salario;}
    //Setters
    //----------------
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    //Métodos
    //----------------
    public abstract double calcularSalario();

}
