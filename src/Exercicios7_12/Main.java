package Exercicios7_12;

import Utilidades.Erros.CpfInvalidoException;
import Utilidades.Erros.SenhaIncorretaException;
import Utilidades.ValidarCpf;

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
                    6)Sair
                    
                    """);
            int opcao = scan.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("""
                            
                            Qual o tipo do funcionário?
                            1) Vendedor
                            2) Gerente
                            3) Secretária
                            
                            """);
                    int tipo = scan.nextInt();
                    switch (tipo){
                        case 1:
                            System.out.println("\nForneça o nome:");
                            String nomeVendedor = scan.nextLine();
                            System.out.println("\nForneça o sobrenome:");
                            String sobrenomeVendedor = scan.nextLine();
                            System.out.println("\nForneça o CPF:");
                            String cpfVendedor = scan.nextLine();
                            while(!ValidarCpf.validar(cpfVendedor)){
                                System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                                cpfVendedor = scan.nextLine();
                            }
                            System.out.println("\nForneça o Salario:");
                            double salarioVendedor = scan.nextDouble();

                            Vendedor vendedor = new Vendedor(nomeVendedor, sobrenomeVendedor, cpfVendedor, salarioVendedor);
                            try{
                                empresa.adicionarFuncionario(vendedor);
                            } catch (CpfInvalidoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            System.out.println("\nForneça o nome:");
                            String nomeGerente = scan.nextLine();
                            System.out.println("\nForneça o sobrenome:");
                            String sobrenomeGerente = scan.nextLine();
                            System.out.println("\nForneça o CPF:");
                            String cpfGerente = scan.nextLine();
                            while(!ValidarCpf.validar(cpfGerente)){
                                System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                                cpfGerente = scan.nextLine();
                            }
                            System.out.println("\nForneça o Salario:");
                            double salarioGerente = scan.nextDouble();
                            System.out.println("\nForneça uma senha:");
                            String senha = scan.nextLine();

                            Gerente gerente = new Gerente(nomeGerente, sobrenomeGerente, cpfGerente, salarioGerente, senha);
                            try{
                                empresa.adicionarFuncionario(gerente);
                            } catch (CpfInvalidoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

//                        case 3:
//                            System.out.println("Forneça o nome:");
//                            String nomeSecretaria = scan.nextLine();
//                            System.out.println("Forneça o sobrenome:");
//                            String sobrenomeSecretaria = scan.nextLine();
//                            System.out.println("Forneça o CPF:");
//                            String cpfSecretaria = scan.nextLine();
//                            System.out.println("Forneça o Salario:");
//                            double salarioSecretaria = scan.nextDouble();
//                            System.out.println("Sabe um idioma adicional? (1 - sim, 2 - não");
//                            boolean idiomaAdicional = scan.nextInt() == 1;
//
//                            Secretaria secretaria = new Secretaria(nomeSecretaria, sobrenomeSecretaria, cpfSecretaria, salarioSecretaria, idiomaAdicional);
//                            try{
//                                empresa.adicionarFuncionario(secretaria);
//                            } catch (CpfInvalidoException e) {
//                                System.out.println(e.getMessage());
//                            }
//                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nInsira o cpf do funcionário que deseja remover");
                    String cpfRemocao = scan.nextLine();
                    while(!ValidarCpf.validar(cpfRemocao)){
                        System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                        cpfRemocao = scan.nextLine();
                    }

                    try{
                        empresa.removerFuncionario(cpfRemocao);
                    } catch (CpfInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\nInsira o cpf do funcionário que deseja buscar");
                    String cpfBusca = scan.nextLine();
                    while(!ValidarCpf.validar(cpfBusca)){
                        System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                        cpfBusca = scan.nextLine();
                    }

                    try{
                        var func = empresa.buscarFuncionario(cpfBusca);
                        System.out.println("\nNome: " + func.getNomeCompleto() + "\tCPF: " + func.getCpf());
                    } catch (CpfInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\nInsira o cpf do funcionário que deseja calcular o salário");
                    String cpfSalario = scan.nextLine();
                    while(!ValidarCpf.validar(cpfSalario)){
                        System.out.println("CPF inválido. Digite apenas números, sem pontos ou hífen");
                        cpfSalario = scan.nextLine();
                    }

                    try{
                        var salario = empresa.buscarFuncionario(cpfSalario).calcularSalario();
                        System.out.println("O salário do funcionário é de " + salario + " reais");
                    } catch (CpfInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\nInsira o cpf do gerente que deseja autenticar");
                    String cpfGerente = scan.nextLine();
                    while(!ValidarCpf.validar(cpfGerente)){
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
                        }
                    } catch (CpfInvalidoException | SenhaIncorretaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("\nTchauzinho");
                    rodando = false;
                    break;
            }
        }
    }
}
