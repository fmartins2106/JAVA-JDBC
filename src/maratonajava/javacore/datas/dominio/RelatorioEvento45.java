package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento45 {

    public void gerarEvento(List<EventoBase45> eventoBase45s){
        Path pastaArquivo = Paths.get("relatorio");
        try {
            if (Files.notExists(pastaArquivo)){
                Files.createDirectories(pastaArquivo);
            }
            Path caminhoArquivo = pastaArquivo.resolve("relatorio_evento.csv");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append("\"nome evento\",\"local evento\",\"data e hora\"\n");
            for (EventoBase45 eventoBase45 : eventoBase45s) {
                String linha = String.format("\"%s\",\"%s\",\"%s\"",eventoBase45.getNomeEvento(),
                        eventoBase45.getLocalEvento(),eventoBase45.getDataHora().format(formatter));
                conteudo.append(linha).append("\n");
            }
            Files.writeString(caminhoArquivo,conteudo, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
