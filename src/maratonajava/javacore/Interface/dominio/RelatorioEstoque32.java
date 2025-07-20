package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEstoque32 {

    public void gerarRelatorio(List<ProdutoBase32> produtoBase32s){
        Path pastaArquivo = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaArquivo)){
                Files.createDirectories(pastaArquivo);
                return;
            }
            Path caminhoArquivo = pastaArquivo.resolve("relatorio_estoque.csv");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append(String.format("%-20s, %-10s, %-10s, %-10s, %-20s\n",
                    "NOME","PREÇO","QUANTIDADE","ESTOQUE MÍNIMO","EXTRA"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (ProdutoBase32 produtoBase32 : produtoBase32s) {
                String extra = "";
                if (produtoBase32 instanceof ProdutoPerecivel32){
                    ProdutoPerecivel32 produtoPerecivel32 = (ProdutoPerecivel32) produtoBase32;
                    extra = "VALIDADE:"+produtoPerecivel32.getDataValidade().format(formatter);
                }
                if (produtoBase32 instanceof ProdutosNaoPereciveis32){
                    ProdutosNaoPereciveis32 produtosNaoPereciveis32 = (ProdutosNaoPereciveis32) produtoBase32;
                    extra = "MESES GARANTIA:"+produtosNaoPereciveis32.getMesesGarantia()+" |CATEGORIA:"+
                            produtosNaoPereciveis32.getCategoria();

                }
                String linha = String.format("%-20s, %-10s, %-10s, %-10s, %-20s\n",produtoBase32.getNome(),
                        produtoBase32.getPreco(),produtoBase32.getQuantidade(),produtoBase32.getEstoqueMinimo(),
                        extra);
                conteudo.append(linha);
            }
            Files.writeString(caminhoArquivo,conteudo.toString(), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso:"+pastaArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
