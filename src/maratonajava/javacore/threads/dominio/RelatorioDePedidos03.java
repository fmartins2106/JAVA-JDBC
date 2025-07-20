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

public class RelatorioDePedidos03 {
    public synchronized void gerarRelatorio(Pedido03 pedido03,double imposto, double frete, double total){
        try {
            Path pasta = Paths.get("relatorios");
            if (Files.notExists(pasta)){
                Files.createDirectories(pasta);
            }
            Path arquivo = pasta.resolve("relatorio_de_pedidos.txt");
            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                 PrintWriter out = new PrintWriter(writer)) {
                out.printf("[%s] |Pedido:#%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f\n"
                        ,timeStamp,pedido03.id,pedido03.getCliente(),total,imposto,frete);
            }
        }catch (IOException e){
            System.out.println("Erro ao gerar relatório:"+e.getMessage());
        }
    }
}
