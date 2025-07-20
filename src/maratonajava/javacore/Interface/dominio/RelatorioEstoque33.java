package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEstoque33 {

    public void gerarRelatorio(List<ProdutoBase33> produtoBase33s){
        Path pastaArquivo = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaArquivo)){
                Files.createDirectories(pastaArquivo);
            }
            Path caminhoArquivo = pastaArquivo.resolve("relatorio_estoque.csv");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append("\"nome\",\"preço\",\"quantidade\",\"estoque mínimo\",\"extra\"\n");
            String extra = "";
            for (ProdutoBase33 produtoBase33 : produtoBase33s) {
                if (produtoBase33 instanceof ProdutoPerecivel33){
                    ProdutoPerecivel33 produtoPerecivel33 = (ProdutoPerecivel33) produtoBase33;
                    extra = String.format("validade:"+produtoPerecivel33.getDataValidade().format(formatter));
                }
                if (produtoBase33 instanceof ProdutosNaoPerecivel33){
                    ProdutosNaoPerecivel33 produtosNaoPerecivel33 = (ProdutosNaoPerecivel33) produtoBase33;
                    extra = String.format("Meses Garantia:"+produtosNaoPerecivel33.getMesesGarantia()+" | Categoria:"+produtosNaoPerecivel33.getCategoria());
                }
                String linha = (String.format("\"%s\",\"%.2f\",\"%d\",\"%d\",\"%s\"\n",produtoBase33.getNome(),
                        produtoBase33.getPreco(),produtoBase33.getQuantidade(),produtoBase33.getEstoqueMinimo(), extra));
                conteudo.append(linha);
            }
            Files.writeString(caminhoArquivo,conteudo, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
