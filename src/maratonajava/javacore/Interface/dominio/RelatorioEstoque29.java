package academy.devdojo.maratonajava.javacore.Interface.dominio;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEstoque29 {

    public void gerarRelatorioEstoque(List<ProdutoBase29> produtoBase29s){
        File pastaRelatorio = new File("relatorios");
        if (!pastaRelatorio.exists()){
            pastaRelatorio.mkdir();
        }

        String nomeArquivo = "relatorios/relatorio_estoque.csv";

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(nomeArquivo),StandardCharsets.UTF_8))){
            writer.write(String.format("%-20s; %-10s; %-10s; %-15s; %-20s%n",
                    "NOME","PREÇO","QUANTIDADE","ESTOQUE MÍNIMO","EXTRA"));
            for (ProdutoBase29 produtoBase29 : produtoBase29s) {
                String extraInfo = "";
                if (produtoBase29 instanceof ProdutoPerecivel29){
                    ProdutoPerecivel29 produtoPerecivel29 = (ProdutoPerecivel29) produtoBase29;
                    extraInfo = "Validade:"+ produtoPerecivel29.getDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } else if (produtoBase29 instanceof ProdutoNaoPerecivel29) {
                    ProdutoNaoPerecivel29 produtoNaoPerecivel29 = (ProdutoNaoPerecivel29) produtoBase29;
                    extraInfo = "Meses Garantia:"+ produtoNaoPerecivel29.getMesesGarantia() + " Categoria:"+produtoNaoPerecivel29.getCategoria();
                }

                String linha = String.format("%-20s; %-10s; %-10s; %-15s; %-20s%n",produtoBase29.getNome(),produtoBase29.getPreco()
                ,produtoBase29.getQuantidade(),produtoBase29.getEstoqueMinimo(),extraInfo);
                writer.write(linha);
            }
            System.out.println("Relatório gerado com sucesso em:"+nomeArquivo);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
