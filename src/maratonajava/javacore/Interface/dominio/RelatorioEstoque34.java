package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class RelatorioEstoque34 {

    public void gerarRelatorio(List<ProdutoBase34> produtoBase34s){
        Path pastaArquivo = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaArquivo)){
                Files.createDirectories(pastaArquivo);
            }
            Path caminhoArquivo = pastaArquivo.resolve("relatorio_estoque.csv");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append("\"nome\",\"preço\",\"quantidade\",\"estoque mínimo\",\"extra\"\n");
            for (ProdutoBase34 produtoBase34 : produtoBase34s) {
                String extra = "";
                if (produtoBase34 instanceof ProdutoPerecivel34){
                    ProdutoPerecivel34 produtoPerecivel34 = (ProdutoPerecivel34) produtoBase34;
                    extra = String.format(" |Data de validade:"+produtoPerecivel34.getDataValidade().format(formatter));
                }
                if (produtoBase34 instanceof ProdutosNaoPereciveis34){
                    ProdutosNaoPereciveis34 produtosNaoPereciveis34 = (ProdutosNaoPereciveis34) produtoBase34;
                    extra = String.format(" |Meses de garantia:"+produtosNaoPereciveis34.getMesesGarantia()+
                            " |Categoria:"+produtosNaoPereciveis34.getCategoria());
                }
                String linha = String.format("\"%s\",\"%.2f\",\"%d\",\"%d\",\"%s\"\n",produtoBase34.getNome(),
                        produtoBase34.getPreco(),produtoBase34.getQuantidade(),produtoBase34.getEstoqueMinimo(),extra);
                conteudo.append(linha);
            }

            Files.writeString(caminhoArquivo,conteudo, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//    private static void gerarRelatorio(List<ProdutoBase34>produtoBase34s){
//        Path pastaArquivo = Paths.get("relatorio");
//        try {
//            if (Files.notExists(pastaArquivo)){
//                Files.createDirectories(pastaArquivo);
//            }
//            Path caminhoArquivo = pastaArquivo.resolve("relatorio_estoque.csv");
//            StringBuilder conteudo = new StringBuilder();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//            conteudo.append("\"nome\",\"Preço\",\"Quantidade\",\"Estoque mínimo\",\"Extra\"\n");
//            String extra = "";
//            for (ProdutoBase34 produtoBase34 : produtoBase34s) {
//                if (produtoBase34 instanceof ProdutoPerecivel34){
//                    ProdutoPerecivel34 produtoPerecivel34 = (ProdutoPerecivel34) produtoBase34;
//                    extra = String.format("Data Validade"+produtoPerecivel34.getDataValidade().format(formatter));
//                }
//                if (produtoBase34 instanceof ProdutosNaoPereciveis34){
//                    ProdutosNaoPereciveis34 produtosNaoPereciveis34 = (ProdutosNaoPereciveis34) produtoBase34;
//                    extra = String.format("Meses Garantia:"+produtosNaoPereciveis34.getMesesGarantia()
//                    +" |Categoria:"+produtosNaoPereciveis34.getCategoria());
//                }
//                String linha = String.format("\"%s\",\"%.2f\",\"%d\",\"%d\",\"%s\"",produtoBase34.getNome(),produtoBase34.getPreco(),
//                        produtoBase34.getQuantidade(),produtoBase34.getEstoqueMinimo(),extra);
//                conteudo.append(linha).append("\n");
//            }
//            Files.writeString(caminhoArquivo,conteudo,StandardCharsets.UTF_8,StandardOpenOption.CREATE,
//                    StandardOpenOption.TRUNCATE_EXISTING);
//            System.out.println("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//


//    public void gerarRelatorio2(List<ProdutoBase34>  produtoBase34s){
//        Path pastaArquivo = Paths.get("relatorio");
//        try {
//            if (Files.notExists(pastaArquivo)){
//                Files.createDirectories(pastaArquivo);
//            }
//            Path caminhoArquivo = pastaArquivo.resolve("relatorio_Estoque.csv");
//            StringBuilder conteudo = new StringBuilder();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            conteudo.append("\"nome\",\"preco\",\"quantidade\",\"estoque mínimo\",\"extra\"\n");
//
//            for (ProdutoBase34 produtoBase34 : produtoBase34s) {
//                String extra = "";
//                if (produtoBase34 instanceof ProdutoPerecivel34){
//                    ProdutoPerecivel34 produtoPerecivel34 = (ProdutoPerecivel34) produtoBase34;
//                    extra = String.format("Data de validade:"+produtoPerecivel34.getDataValidade().format(formatter));
//                }
//                if (produtoBase34 instanceof ProdutosNaoPereciveis34){
//                    ProdutosNaoPereciveis34 produtosNaoPereciveis34 = (ProdutosNaoPereciveis34) produtoBase34;
//                    extra = String.format("Meses garantia:"+produtosNaoPereciveis34.getMesesGarantia()
//                            +" |Categoria:"+produtosNaoPereciveis34.getCategoria());
//                }
//                String linha = String.format("\"%s\",\"%.2f\",\"%d\",\"%d\",\"%s\"",produtoBase34.getNome(),
//                        produtoBase34.getPreco(),produtoBase34.getQuantidade(),produtoBase34.getEstoqueMinimo(),extra));
//                conteudo.append(linha).append("\n");
//            }
//            Files.writeString(caminhoArquivo,conteudo,StandardCharsets.UTF_8,StandardOpenOption.CREATE,
//                    StandardOpenOption.TRUNCATE_EXISTING);
//        }catch (IOException e){
//            System.err.println("Erro ao gerar relatório:"+e.getMessage());
//        }
//    }

}
