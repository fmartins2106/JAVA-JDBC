package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelatorioDePedidos10 {

    public synchronized void gerarRelatorio(Pedido10 pedido10, BigDecimal imposto, BigDecimal frete, BigDecimal total){
        try {
            Path pasta = Paths.get("relatorio");
            if (Files.notExists(pasta)){
                Files.createFile(pasta);
            }
            Path arquivo = pasta.resolve("relatorio_pedidos.txt");
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND); PrintWriter out = new PrintWriter(writer)){
                out.printf("[%s] -> ID:#%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n",
                        dataHora,pedido10.getId(),pedido10.getCliente(),pedido10.getValor(),imposto,frete,total);
            }
        }catch (IOException e){
            System.out.println("Erro ao gerar relatório."+e.getMessage());
        }
    }
}
