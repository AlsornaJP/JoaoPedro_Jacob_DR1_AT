package Utilidades;

import Exercicios7_12.Funcionario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogUtil {
    public static void salvarLog(String acao, Funcionario f) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Saidas/logs.txt", true))) {
            writer.write("[" + java.time.LocalDateTime.now() + "] "
                    + acao
                    + " - Tipo: " + f.getClass().getSimpleName()
                    + " | Nome: " + f.getNomeCompleto()
                    + " | CPF: " + f.getCpf());

            writer.newLine();

        } catch (IOException e) {
            System.out.println("Erro ao salvar log");
        }
    }
    public static void salvarErro(Exception e){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Saidas/erros.txt", true))){
            writer.write("[" + LocalDateTime.now() + "] "
                    + e.getClass().getSimpleName() + ": "
                    + e.getMessage());
            writer.newLine();

        } catch (IOException ex) {
            System.out.println("Erro ao salvar log");
        }
    }
    public static void salvarFolhaSalarial(double valor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Saidas/folha_salarial.txt", true))) {
            writer.write("[" + java.time.LocalDateTime.now().getMonth() + "] "
                    + "FOLHA_SALARIAL - Total: R$ " + valor);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Erro ao salvar log da folha");
        }
    }
}

