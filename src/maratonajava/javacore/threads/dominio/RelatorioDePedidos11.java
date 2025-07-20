package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelatorioDePedidos11 {

    public synchronized void gerarRelatorio(Pedido11 pedido11, BigDecimal imposto, BigDecimal frete, BigDecimal total){
        try {
            Path pasta = Paths.get("relatorio");
            if (Files.notExists(pasta)){
                Files.createFile(pasta);
            }
            Path arquivo = pasta.resolve("relatorioDe_Pedidos.txt");
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND); PrintWriter out = new PrintWriter(writer)){
                out.printf("[%s] -> #ID:%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n",
                        timeStamp,pedido11.getId(),pedido11.getCliente(),pedido11.getValor(),imposto,frete,total);

            }
        }catch (IOException e){
            System.out.println("Erro ao gerar o relatório."+e.getMessage());
        }
    }
}
