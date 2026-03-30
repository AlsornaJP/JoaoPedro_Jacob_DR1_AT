package Exercicios7_12;

public class Secretaria extends Funcionario{
    //Construtor
    //----------------
    public Secretaria(String nome, String cpf, String sobrenome, double salario, boolean idiomaAdicional) {
        super(nome, cpf, sobrenome, salario);
        this.idiomaAdicional = idiomaAdicional;
    }
    //Atributos
    //----------------
    private final boolean idiomaAdicional;
    //Métodos
    //----------------
    @Override
    public double calcularSalario() {
        if (idiomaAdicional){
            return salario * 1.1;
        }
        return salario;
    }
}
