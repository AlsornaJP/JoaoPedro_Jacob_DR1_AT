package Exercicios7_12;

import Utilidades.Erros.CpfInvalidoException;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    //Construtor
    //----------------
    public Empresa() {this.funcionarios = new ArrayList<>();}
    //Atributos
    //----------------
    private List<Funcionario> funcionarios;
    //Métodos
    //----------------
    public void adicionarFuncionario(Funcionario novoFuncionario) throws CpfInvalidoException {
        validarFuncionario(novoFuncionario);
        funcionarios.add(novoFuncionario);
        System.out.println("\nFuncionário adicionado com sucesso");
    }
    private void validarFuncionario(Funcionario novoFuncionario)throws CpfInvalidoException{
        for(Funcionario f : funcionarios){
            if(f.getCpf().equals(novoFuncionario.getCpf())){
                throw new CpfInvalidoException("\nCPF " + novoFuncionario.getCpf() + " já existe no banco de funcionários");
            }
        }
    }
    public void removerFuncionario(String cpf) throws CpfInvalidoException{
        for(Funcionario f : funcionarios){
            if (f.getCpf().equals(cpf)){
                funcionarios.remove(f);
                break;
            }
            throw new CpfInvalidoException("\n Funcionário não existe no banco de funcionários");
        }
    }
    public Funcionario buscarFuncionario(String cpf) throws CpfInvalidoException{
        for(Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        throw new CpfInvalidoException("\n Funcionário não existe no banco de funcionários");
    }
    public void listarFuncionarios(){
        for(Funcionario f : funcionarios){
            System.out.println("\nNome: " + f.getNomeCompleto() + "\tCPF: " + f.getCpf());
        }
    }
}
