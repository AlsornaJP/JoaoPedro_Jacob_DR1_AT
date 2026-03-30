package Exercicios7_12;

import Utilidades.Erros.CpfDuplicadoException;
import Utilidades.Erros.CpfInexistenteException;
import Utilidades.Erros.SenhaIncorretaException;

import java.util.ArrayList;
import java.util.List;

public class Testes {
   static void main(String[] args){
    // testando funcionários (questão 8)
    List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Vendedor("Joao", "Ribeiro", "22222222222", 5000));
        funcionarios.add(new Gerente("Joao", "Jacob", "11111111111", 7000.00, "123"));

        for (Funcionario f: funcionarios){
            System.out.println("\nnome: " + f.getNomeCompleto() + "\tSalário: " +  f.getSalario());
            if (f instanceof Gerente g){
                try {
                    if (g.autenticar("123")){
                       System.out.println("Senha correta");
                    }
                } catch (SenhaIncorretaException e) {
                     System.out.println(e.getMessage());
                }
            }
        }
    //testando classe empresa (questão 9)
        Empresa teste = new Empresa();
        try{
        teste.adicionarFuncionario(funcionarios.get(0));
    } catch (CpfDuplicadoException e) {
        System.out.println(e.getMessage());
    }
        try{
        teste.adicionarFuncionario(funcionarios.get(1));
    } catch (CpfDuplicadoException e) {
        System.out.println(e.getMessage());
    }
        try{
            var funcionario = teste.buscarFuncionario("22222222222");
            var salario = funcionario.calcularSalario();
            System.out.println(salario);
        } catch (CpfInexistenteException e) {
            System.out.println("deu erro");
        }
   }
}
