package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;

public class RelatorioDePedidos04 {
    public synchronized void gerarRelatorio(Pedido04 pedido04, double imposto, double frete, double total){
        try {
            Path pasta = Paths.get("relatorios_pedidos");
            if (Files.notExists(pasta)){
                Files.createDirectories(pasta);
            }
            Path arquivo = pasta.resolve("relatorio_pedidos.txt");
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                 PrintWriter out = new PrintWriter(writer)) {
                 out.printf("[%s] -> Pedido:#ID:%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n",
                         timeStamp,pedido04.getId(),pedido04.getCliente(),pedido04.getValor(),imposto,frete,total);
            }
        }catch (IOException e){
            System.out.printf("Erro ao gerar relatório:"+e.getMessage());
        }
    }
}
