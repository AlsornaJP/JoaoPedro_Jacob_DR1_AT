package Exercicios7_12;

import Utilidades.Erros.*;
import Utilidades.LogUtil;
import Utilidades.ValidarCpf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Empresa empresa = new Empresa();

        //menu
        boolean rodando = true;
        while(rodando){
            System.out.println("""
                    O que deseja fazer?
                    
                    1)Cadastrar funcionário
                    2)Remover funcionário
                    3)Listar funcionários
                    4)Calcular salários
                    5)Validar gerente
                    6)Exibir folha mensal
                    7)Listar funcionários por período
                    8)Sair
                    
                    """);
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("""
                            
                            Qual o tipo do funcionário?
                            1) Vendedor
                            2) Gerente
                            3) Secretária
                            
                            """);
                    int tipo = scan.nextInt();
                    scan.nextLine();
                    switch (tipo){
                        case 1:
                            System.out.println("\nForneça o nome:");
                            String nomeVendedor = scan.nextLine();
                            System.out.println("\nForneça o sobrenome:");
                            String sobrenomeVendedor = scan.nextLine();
                            System.out.println("\nForneça o CPF:");
                            String cpfVendedor = scan.nextLine();
                            while(ValidarCpf.validar(cpfVendedor)){
                                System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                                cpfVendedor = scan.nextLine();
                            }
                            System.out.println("\nForneça o Salario:");
                            double salarioVendedor = scan.nextDouble();
                            scan.nextLine();

                            try{
                                Vendedor vendedor = new Vendedor(nomeVendedor, sobrenomeVendedor, cpfVendedor, salarioVendedor);
                                empresa.adicionarFuncionario(vendedor);
                                LogUtil.salvarLog("Adicionar", vendedor);
                            } catch (CpfDuplicadoException | IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                LogUtil.salvarErro(e);
                            }
                            break;

                        case 2:
                            System.out.println("\nForneça o nome:");
                            String nomeGerente = scan.nextLine();
                            System.out.println("\nForneça o sobrenome:");
                            String sobrenomeGerente = scan.nextLine();
                            System.out.println("\nForneça o CPF:");
                            String cpfGerente = scan.nextLine();
                            while(ValidarCpf.validar(cpfGerente)){
                                System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                                cpfGerente = scan.nextLine();
                            }
                            System.out.println("\nForneça o Salario:");
                            double salarioGerente = scan.nextDouble();
                            scan.nextLine();
                            System.out.println("\nForneça uma senha:");
                            String senha = scan.nextLine();


                            try{
                                Gerente gerente = new Gerente(nomeGerente, sobrenomeGerente, cpfGerente, salarioGerente, senha);
                                empresa.adicionarFuncionario(gerente);
                                LogUtil.salvarLog("Adicionar", gerente);
                            } catch (CpfDuplicadoException | IllegalArgumentException | SenhaInvalidaException e) {
                                System.out.println(e.getMessage());
                                LogUtil.salvarErro(e);
                            }
                            break;

                        case 3:
                            System.out.println("Forneça o nome:");
                            String nomeSecretaria = scan.nextLine();
                            System.out.println("Forneça o sobrenome:");
                            String sobrenomeSecretaria = scan.nextLine();
                            System.out.println("Forneça o CPF:");
                            String cpfSecretaria = scan.nextLine();
                            while(ValidarCpf.validar(cpfSecretaria)){
                                System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                                cpfSecretaria = scan.nextLine();
                            }
                            System.out.println("Forneça o Salario:");
                            double salarioSecretaria = scan.nextDouble();
                            scan.nextLine();
                            System.out.println("Sabe um idioma adicional? (1 - sim, 2 - não");
                            boolean idiomaAdicional = scan.nextInt() == 1;
                            scan.nextLine();

                            try{
                                Secretaria secretaria = new Secretaria(nomeSecretaria, sobrenomeSecretaria, cpfSecretaria, salarioSecretaria, idiomaAdicional);
                                empresa.adicionarFuncionario(secretaria);
                                LogUtil.salvarLog("Adicionar", secretaria);
                            } catch (CpfDuplicadoException | IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                LogUtil.salvarErro(e);
                            }
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nInsira o cpf do funcionário que deseja remover");
                    String cpfRemocao = scan.nextLine();
                    while(ValidarCpf.validar(cpfRemocao)){
                        System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                        cpfRemocao = scan.nextLine();
                    }

                    try{
                        LogUtil.salvarLog("Remover", empresa.buscarFuncionario(cpfRemocao));
                        empresa.removerFuncionario(cpfRemocao);
                    } catch (CpfInexistenteException e) {
                        System.out.println(e.getMessage());
                        LogUtil.salvarErro(e);
                    }
                    break;

                case 3:
                    System.out.println("\nInsira o cpf do funcionário que deseja buscar");
                    String cpfBusca = scan.nextLine();
                    while(ValidarCpf.validar(cpfBusca)){
                        System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                        cpfBusca = scan.nextLine();
                    }

                    try{
                        var func = empresa.buscarFuncionario(cpfBusca);
                        System.out.println("\nNome: " + func.getNomeCompleto() + "\tCPF: " + func.getCpf());
                        LogUtil.salvarLog("Busca", func);
                    } catch (CpfInexistenteException e) {
                        System.out.println(e.getMessage());
                        LogUtil.salvarErro(e);
                    }
                    break;

                case 4:
                    System.out.println("\nInsira o cpf do funcionário que deseja calcular o salário");
                    String cpfSalario = scan.nextLine();
                    while(ValidarCpf.validar(cpfSalario)){
                        System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                        cpfSalario = scan.nextLine();
                    }

                    try{
                        var func = empresa.buscarFuncionario(cpfSalario);
                        var salario = func.calcularSalario();
                        System.out.println("O salário do funcionário é de " + salario + " reais");
                        LogUtil.salvarLog("Calcular salário", func);
                    } catch (CpfInexistenteException e) {
                        System.out.println(e.getMessage());
                        LogUtil.salvarErro(e);
                    }
                    break;

                case 5:
                    System.out.println("\nInsira o cpf do gerente que deseja autenticar");
                    String cpfGerente = scan.nextLine();
                    while(ValidarCpf.validar(cpfGerente)){
                        System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                        cpfGerente = scan.nextLine();
                    }

                    try {
                        var func = empresa.buscarFuncionario(cpfGerente);
                        if (!(func instanceof Gerente ger)) {
                            System.out.println("Não é gerente");
                            break;
                        }

                        System.out.println("Digite a senha:");
                        String senha = scan.nextLine();

                        if (ger.autenticar(senha)) {
                            System.out.println("Senha correta");
                            LogUtil.salvarLog("Autenticar", ger);
                        }
                    } catch (CpfInexistenteException | SenhaIncorretaException e) {
                        System.out.println(e.getMessage());
                        LogUtil.salvarErro(e);
                    }
                    break;

                case 6:
                    var folhaMensal = empresa.calcularFolhaSalarial();
                    LogUtil.salvarFolhaSalarial(folhaMensal);
                    System.out.println("A folha salarial mensal é de R$ " + folhaMensal);
                    break;

                case 7:
                    DateTimeFormatter formatadorDatas = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    System.out.println("Digite a data inicial (dd/MM/yyyy):");
                    LocalDate dataInicial = LocalDate.parse(scan.nextLine(), formatadorDatas);
                    System.out.println("Digite a data final (dd/MM/yyyy):");
                    LocalDate dataFinal = LocalDate.parse(scan.nextLine(), formatadorDatas);

                    try {
                        empresa.buscarPorPeriodo(dataInicial, dataFinal);
                    } catch (DatasIncompativeisException e) {
                        System.out.println(e.getMessage());
                        LogUtil.salvarErro(e);
                    }
                    break;

                case 8:
                    System.out.println("\nTchauzinho");
                    rodando = false;
                    break;
            }
        }
    }
}
