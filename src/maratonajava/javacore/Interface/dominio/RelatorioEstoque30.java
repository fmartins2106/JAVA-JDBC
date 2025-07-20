package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEstoque30 {

    public void gerarRelatorioEstoque(List<ProdutoBase30> produtoBase30s){
        File pastaRelatorio = new File("relatorios");
        if (!pastaRelatorio.exists()){
            pastaRelatorio.mkdir();
        }

        String nomeArquivo = "relatorios/relatorio_estoque.csv";
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(nomeArquivo), StandardCharsets.UTF_8))){
            writer.write(String.format("%-20s;%-10s;%-10s;%-15s;%-20s%n",
                    "NOME","PREÇO","QUANTIDADE","ESTOQUE MÍNIMO","EXTRA"));
            for (ProdutoBase30 produtoBase30 : produtoBase30s) {
                String extrainfo = "";
                if (produtoBase30 instanceof ProdutoPerecivel30){
                    ProdutoPerecivel30 produtoPerecivel30 = (ProdutoPerecivel30) produtoBase30;
                    extrainfo = "Válidade:"+produtoPerecivel30.getDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                }
                if (produtoBase30 instanceof ProdutosNaoPereciveis30){
                    ProdutosNaoPereciveis30 produtosNaoPereciveis30 = (ProdutosNaoPereciveis30) produtoBase30;
                    extrainfo = "Meses Garantia:"+produtosNaoPereciveis30.getMesesGarantia()+" Categoria:"+produtosNaoPereciveis30.getCategoria();
                }
                String linha = String.format("%-20s; %-10s; %-10s; %-15s; %-20s%n", produtoBase30.getNome(),
                        produtoBase30.getPreco(),produtoBase30.getQuantidade(),produtoBase30.getEstoqueMinimo(),extrainfo);
                writer.write(linha);
            }
            System.out.println("Relatório gerado com sucesso em:"+nomeArquivo);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
