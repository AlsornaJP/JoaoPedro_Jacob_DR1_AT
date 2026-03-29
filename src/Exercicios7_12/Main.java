package Exercicios7_12;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args){
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Vendedor("Joao", "Ribeiro", "222.222.222-22", 5000));
        funcionarios.add(new Gerente("Joao", "Jacob", "111.111.111-11", 7000.00, "123"));

        for (Funcionario f: funcionarios){
            System.out.println("\nnome: " + f.getNomeCompleto() + "\tSalário: " +  f.getSalario());
            if (f.getClass().equals(Gerente.class)){
                Gerente g = (Gerente) f;
                boolean autenticado = g.autenticar("123");
                if (autenticado){
                    System.out.println("Senha correta");
                }else {
                    System.out.println("Senha incorreta");
                }
            }
//            try{
//                Gerente g = (Gerente) f;
//                boolean autenticado = g.autenticar("123");
//                if (autenticado){
//                    System.out.println("Senha correta");
//                }else {
//                    System.out.println("Senha incorreta");
//                }
//            } catch (Exception e) {
//                System.out.println("Não é gerente");
//            }
        }
    }
}
