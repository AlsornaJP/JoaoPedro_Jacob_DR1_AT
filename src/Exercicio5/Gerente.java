package Exercicio5;

import Utilidades.DoubleUtil;

public class Gerente extends Funcionario {

    public Gerente(String nome, double salariobase) {
        super(nome, salariobase);
    }

    private double salarioFinal = DoubleUtil.truncarDouble(getSalariobase() * 1.20 ,2);

    public void mostrarSalario(){
        System.out.println("R$ " +  salarioFinal);
    }
}