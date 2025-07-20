package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento37 {

    public void gerarRelatorio(List<EventoBase37> eventoBase37s){
        File pastaRelatorio = new File("relatorios");
        if (!pastaRelatorio.exists()){
            pastaRelatorio.mkdir();
        }

        String nomeArquivo = "relatorios/relatorio_eventos.csv";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(nomeArquivo),StandardCharsets.UTF_8))){
            writer.write("\"nome\",\"Local\",\"Data e hora\"\n");
            for (EventoBase37 eventoBase37 : eventoBase37s) {
                String linha = String.format("\"%s\",\"%s\",\"%s\"", eventoBase37.nomeEvento,
                        eventoBase37.localEvento,eventoBase37.dataHora.format(formatter));
                writer.write(linha+"\n");
            }
            System.out.println("Relatório gerado com sucesso em:"+nomeArquivo);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
