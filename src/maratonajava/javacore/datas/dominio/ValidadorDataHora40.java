
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Optional;

public class ValidadorDataHora40 {

    public static Optional<LocalDateTime> validandoDataHora(int ano, int mes, int dia, int minuto, int hora){
        try {
            return Optional.of(LocalDateTime.of(ano,mes,dia,mes,hora));
        }catch (DateTimeException e){
            System.err.println("Erro: Data ou hora inválida."+e.getMessage());
            return Optional.empty();
        }
    }
}
