package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RelatorioVeiculos45 {

    public void gerarRelatorio(List<Veiculo45> veiculo45s){
        File pastaRelatorio = new File("relatorio");
        if (!pastaRelatorio.exists()){
            pastaRelatorio.mkdir();
        }

        String nomeArquivo = "relatorios/relatorio_evento.csv";
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(nomeArquivo),StandardCharsets.UTF_8))){
            writer.write(String.format("%s;%s;%s;%s%n","PLACA","PREÇO","COR","VALOR DE MERCADO"));
            for (Veiculo45 veiculo45 : veiculo45s) {
                String linha = String.format("%s;%d;%s;%.2f%n",veiculo45.getPlaca(),veiculo45.getAnoFabricacao(),
                        veiculo45.getCor(),veiculo45.getValorMercado());
                writer.write(linha);
            }
            System.out.println("Relatório gerado com sucesso em:"+nomeArquivo);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
