package academy.devdojo.maratonajava.javacore.datas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class datas {

    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter[] formatos = new DateTimeFormatter[] {
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
                DateTimeFormatter.ofLocalizedDateTime(java.time.format.FormatStyle.SHORT).withLocale(new Locale("pt", "BR")),
                DateTimeFormatter.ofLocalizedDateTime(java.time.format.FormatStyle.MEDIUM).withLocale(new Locale("pt", "BR")),
                DateTimeFormatter.ofLocalizedDateTime(java.time.format.FormatStyle.LONG).withLocale(new Locale("pt", "BR")),
                DateTimeFormatter.ofLocalizedDateTime(java.time.format.FormatStyle.FULL).withLocale(new Locale("pt", "BR"))
        };

        for (DateTimeFormatter formato : formatos) {
            System.out.println(agora.format(formato));
        }
    }


}
