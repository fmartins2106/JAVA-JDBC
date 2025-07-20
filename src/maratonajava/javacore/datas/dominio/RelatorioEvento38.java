
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento38 {

    public void gerarRelorios(List<EventoBase38> eventoBase38s){
        File pastaRelatorio = new File("relatorios");
        if (!pastaRelatorio.exists()){
            pastaRelatorio.mkdir();
        }

        String nomeArquivo = "relatorios/relatorio_eventos.csv";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(nomeArquivo), StandardCharsets.UTF_8))){
        writer.write("\"nome\",\"local\",\"data e Hora\"\n");
            for (EventoBase38 eventoBase38 : eventoBase38s) {
                String linha = String.format("\"%s\",\"%s\",\"%s\"", eventoBase38.getNomeEvento(),
                        eventoBase38.getLocalEvento(),eventoBase38.getDataHora().format(formatter));
                writer.write(linha+"\n");
            }
            System.out.println("Relatório gerado com sucesso:"+nomeArquivo);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
