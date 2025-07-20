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

public class RelatorioDePedidos05 {

    public synchronized void gerarRelatorioPedidos(Pedido05 pedido05, double imposto, double frete, double total){
        try {
            Path pasta = Paths.get("relatorios");
            if (Files.notExists(pasta)){
                Files.createDirectories(pasta);
            }
            Path arquivo = pasta.resolve("relatorio_pedidos.txt");
            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                 PrintWriter out = new PrintWriter(writer)){
                out.printf("[%s] - ID Pedido:#%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n",
                        timeStamp,pedido05.getId(),pedido05.getCliente(),pedido05.getValor(),imposto,frete,total);
            }
        }catch (IOException e){
            System.out.println("Erro ao gerar relatório."+e.getMessage());
        }
    }

}
