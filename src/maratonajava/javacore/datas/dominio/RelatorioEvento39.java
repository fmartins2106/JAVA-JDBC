
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento39 {

    public void gerarRelatorio(List<EventoBase39> eventoBase39s){
        Path pastaRelatorio = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaRelatorio)){
                Files.createDirectories(pastaRelatorio);
            }
            Path caminhoArquivo = pastaRelatorio.resolve("relatorio_eventos.csv");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append("\"nome\",\"local\",\"data e hora\"\n");
            for (EventoBase39 eventoBase39 : eventoBase39s) {
                String linha = String.format("\"%s\",\"%s\",\"%s\"",
                        eventoBase39.getNomeEvento(),eventoBase39.getLocalEvento(),
                        eventoBase39.getDataHora().format(formatter));
                conteudo.append(linha).append("\n");
            }
            Files.writeString(caminhoArquivo,conteudo.toString(), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso."+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
