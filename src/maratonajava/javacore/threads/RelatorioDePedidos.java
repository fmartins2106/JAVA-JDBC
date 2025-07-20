package academy.devdojo.maratonajava.javacore.threads;

import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelatorioDePedidos {
    public synchronized void gravarRelatorio(Pedido01 pedido01, double imposto, double frete, double total) {
        try {
            Path pasta = Paths.get("relatorio");
            if (Files.notExists(pasta)) {
                Files.createDirectories(pasta);
            }
            Path arquivo = pasta.resolve("relatorio_pedidos.txt");
            String dateStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                 PrintWriter out = new PrintWriter(writer)) {
                out.printf("[%s] |Pedido:#%d |Cliente: %s |Valor:R$%.2f | Imposoto:R$%.2f |Frete:R$%.2f |Total:R$%.2f%n",
                        dateStamp, pedido01.getId(), pedido01.getCliente(), pedido01.getValor(), imposto
                        , frete, total);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar relatório:" + e.getMessage());

        }
    }
}