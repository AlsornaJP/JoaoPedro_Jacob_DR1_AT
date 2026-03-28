package Exercicio6;

public class Produto {
    public Produto(String nome, int qtd, double precoUnitario) {
        this.nome = nome;
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
    }

    private String nome;
    private int qtd;
    private double precoUnitario;

    public String formatoCSV(){
        return nome + ", " + qtd + ", " + precoUnitario;
    }
}
