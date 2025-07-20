
package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEstoque31 {

    public void gerarRelatorio(List<ProdutoBase31> produtoBase31s){
        Path pastaArquivo = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaArquivo)){
                Files.createDirectories(pastaArquivo);
                return;
            }
            Path caminhoArquivo = pastaArquivo.resolve("relatorio_estoque.csv");
            StringBuilder conteudo = new StringBuilder();

            conteudo.append(String.format("%-20s;%-10s;%-10s;%-15s;%-20s%n",
                    "NOME","PREÇO","QUANTIDADE","ESTOQUE MÍNIMO","EXTRA"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (ProdutoBase31 produtoBase31 : produtoBase31s) {
                String extraInfo="";
                if (produtoBase31 instanceof ProdutoPerecivel31){
                    ProdutoPerecivel31 produtoPerecivel31 = (ProdutoPerecivel31) produtoBase31;
                    extraInfo = "Válidade:"+produtoPerecivel31.getDataValidade().format(formatter);
                }
                if (produtoBase31 instanceof ProdutosNaoPereciveis31){
                    ProdutosNaoPereciveis31 produtosNaoPereciveis31 = (ProdutosNaoPereciveis31) produtoBase31;
                    extraInfo = "Meses garantia:"+produtosNaoPereciveis31.getMesesGarantia()+" Categoria:"+ produtosNaoPereciveis31.getCategoria();
                }
                String linha = String.format("%-20s;%-10s;%-10s;%-15s;%-20s%n",produtoBase31.getNome(),produtoBase31.getPreco(),
                        produtoBase31.getQuantidade(),produtoBase31.getEstoqueMinimo(),extraInfo);
                conteudo.append(linha);
            }
            Files.writeString(caminhoArquivo,conteudo.toString(),StandardCharsets.UTF_8,StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
