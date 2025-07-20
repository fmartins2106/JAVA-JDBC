package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelatorioDePedido01 {
    public synchronized void salvarRelatorio(Pedido01 pedido01,double imposto, double frete, double total){
        try {
            Path pasta = Paths.get("relatorios");
            if (Files.notExists(pasta)) {
                Files.createDirectories(pasta);
            }
            Path arquivo = pasta.resolve("pedido_relatorio.txt");
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                 PrintWriter out = new PrintWriter(writer)){
                out.printf("[%s] Pedido #%d | cliente: %s | Valor:R$%.2f | Imposto:R$%.2f |Frete:R$%.2f | Total:R$%.2f%n",
                        timestamp,pedido01.getId(),pedido01.getCliente(),pedido01.getValor(),imposto,frete,total);
                }
            }catch (IOException e){
            System.out.println("Erro ao salvar relatório:"+e.getMessage());
        }
    }
}
