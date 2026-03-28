package Exercicio6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    static void main(String[] args){
        List<Produto> produtos = List.of(
                new Produto("Banana", 3, 3.99),
                new Produto("Maçã", 2, 6.99),
                new Produto("Pêra", 2, 4.99)
        );

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("out/compras.csv"));
            writer.write("Nome, Quantidade, Preço");
            writer.newLine();
            for(Produto p : produtos){
                writer.write(p.formatoCSV());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
