package Exercicio4;

import Utilidades.DoubleUtil;

public class Aluno {

    public Aluno(String nome, String matricula, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    private String nome;
    private String matricula;
    private double nota1;
    private double nota2;
    private double nota3;
    private String situacao = "Em análise";

    public double calcularMedia(){
        return DoubleUtil.truncarDouble((nota1+nota2+nota3)/3, 1);
    }
    public void verificarAprovacao(){
        double media = calcularMedia();
        situacao =  media >= 7 ? "Aprovado" : "Reprovado";
        System.out.println(situacao.equals("Aprovado") ? "O aluno está aprovado" : "O aluno está reprovado");
    }

}
