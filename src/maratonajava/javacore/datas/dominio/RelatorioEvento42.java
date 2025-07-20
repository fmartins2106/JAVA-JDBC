
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento42 {

    public void gerarRelatorio(List<EventoBase42> eventoBase42s){
        Path pastaArquivo = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaArquivo)){
                Files.createDirectories(pastaArquivo);
            }
            Path caminhoArquivo = pastaArquivo.resolve("relatorio_evento.csv");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append("\"nome evento\",\"local evento\",\"Data e hora\"\n");
            for (EventoBase42 eventoBase42 : eventoBase42s) {
                String linha = String.format("\"%s\",\"%s\",\"%s\"",eventoBase42.getNomeEvento(),eventoBase42.getLocalEvento(),
                        eventoBase42.getDataHora().format(formatter));
                conteudo.append(linha).append("\n");
            }
            Files.writeString(caminhoArquivo,conteudo, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
