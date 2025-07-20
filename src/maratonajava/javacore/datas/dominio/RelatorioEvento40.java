
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento40 {

    public void relatorioEvento(List<EventoBase40> eventoBase40s){
        Path pastaEvento = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaEvento)){
                Files.createDirectories(pastaEvento);
            }
            Path caminhoArquivo = pastaEvento.resolve("relatorio_evento.csv");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append("\"nome\",\"local\",\"data hora\"\n");
            for (EventoBase40 eventoBase40 : eventoBase40s) {
                String linha =  String.format("\"%s\",\"%s\",\"%s\"",eventoBase40.getNomeEvento(),
                eventoBase40.getLocalEvento(),eventoBase40.getDataHora().format(formatter));
                conteudo.append(linha).append("\n");
            }
            Files.writeString(caminhoArquivo,conteudo.toString(), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.print("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
