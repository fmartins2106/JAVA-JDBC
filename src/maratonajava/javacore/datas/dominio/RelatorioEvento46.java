package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento46 {

    public void gerarRelatorio(List<EventoBase46> eventoBase46s){
        Path pastaArquivo = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaArquivo)){
                Files.createDirectories(pastaArquivo);
                return;
            }
            Path caminhoArquivo = pastaArquivo.resolve("Relatorio_Evento.csv");
            StringBuilder conteudo = new StringBuilder();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            conteudo.append("\"nome evento\",\"local evento\",\"data e hora\"\n");
            for (EventoBase46 eventoBase46 : eventoBase46s) {
                String linha = String.format("\"%s\",\"%s\",\"%s\"",eventoBase46.getNomeEvento(),
                        eventoBase46.getLocalEvento(),eventoBase46.getDataHora().format(formatter));
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
