package Exercicios7_12;

import Utilidades.DoubleUtil;
import Utilidades.Erros.CpfInexistenteException;
import Utilidades.Erros.CpfDuplicadoException;
import Utilidades.Erros.DatasIncompativeisException;
import Utilidades.LogUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    //Construtor
    //----------------
    public Empresa() {this.funcionarios = new ArrayList<>();}
    //Atributos
    //----------------
    private final List<Funcionario> funcionarios;
    //Métodos
    //----------------
    public void adicionarFuncionario(Funcionario novoFuncionario) throws CpfDuplicadoException {
        validarFuncionario(novoFuncionario);
        funcionarios.add(novoFuncionario);
        System.out.println("\nFuncionário adicionado com sucesso");
    }
    private void validarFuncionario(Funcionario novoFuncionario)throws CpfDuplicadoException {
        for(Funcionario f : funcionarios){
            if(f.getCpf().equals(novoFuncionario.getCpf())){
                throw new CpfDuplicadoException("\nCPF " + novoFuncionario.getCpf() + " já existe no banco de funcionários");
            }
        }
    }
    public void removerFuncionario(String cpf) throws CpfInexistenteException {
        for(Funcionario f : funcionarios){
            if (f.getCpf().equals(cpf)){
                funcionarios.remove(f);
                break;
            }
            throw new CpfInexistenteException("\n Funcionário não existe no banco de funcionários");
        }
    }
    public Funcionario buscarFuncionario(String cpf) throws CpfInexistenteException {
        for(Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        throw new CpfInexistenteException("\n Funcionário não existe no banco de funcionários");
    }
    public void listarFuncionarios(){
        for(Funcionario f : funcionarios){
            System.out.println("  -> " + f.getClass().getSimpleName()
                    + " | Nome: " + f.getNomeCompleto()
                    + " | CPF: " + f.getCpf());
        }
        LogUtil.salvarListaFuncionarios(funcionarios);
    }
    public double calcularFolhaSalarial(){
        double folhaSalarial = 0;
        for(Funcionario f : funcionarios){
            folhaSalarial+= f.calcularSalario();
        }
        return DoubleUtil.truncarDouble(folhaSalarial, 2);
    }
    public void buscarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) throws DatasIncompativeisException {
        if (dataInicial.isAfter(dataFinal)){
            throw new DatasIncompativeisException("A data inicial não pode ser posterior à data final");
        }
        for (Funcionario f: funcionarios){
            if (f.getDataAdmissao().isAfter(dataInicial) && f.getDataAdmissao().isBefore(dataFinal)){
                System.out.println("  -> " + f.getClass().getSimpleName()
                        + " | Nome: " + f.getNomeCompleto()
                        + " | CPF: " + f.getCpf()
                        + " | Data de Admissão: " + f.getDataAdmissao());
            }
        }
    }
}
