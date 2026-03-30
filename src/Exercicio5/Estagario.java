package Exercicio5;

import Utilidades.DoubleUtil;

class Estagario extends Funcionario {

    public Estagario(String nome, double salariobase) {
        super(nome, salariobase);
    }

    private double salarioFinal = DoubleUtil.truncarDouble(getSalariobase() * 1.10 ,2);

    public void mostrarSalario(){
        System.out.println("R$ " +  salarioFinal);
    }
}
