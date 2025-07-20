package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento43 {
    public void gerarRelatorio(List<EventoBase43>eventoBase43s){
        Path pastaArquivo = Paths.get("relatorio");
        try {
            if (Files.notExists(pastaArquivo)){
                Files.createDirectories(pastaArquivo);
            }
            Path caminhoArquivo = pastaArquivo.resolve("relatorio_evento.csv");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append("\"nome evento\",\"local evento\",\"data e hora\"\n");
            for (EventoBase43 eventoBase43 : eventoBase43s) {
                String linha = String.format("\"%s\",\"%s\",\"%s\"",eventoBase43.getNomerEvento(),
                        eventoBase43.getLocalEvento(),eventoBase43.getDataHora().format(formatter));
                conteudo.append(linha).append("\n");
            }
            Files.writeString(caminhoArquivo,conteudo,StandardCharsets.UTF_8,StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
