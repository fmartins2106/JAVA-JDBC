package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Optional;

public class ValidadorDataHora38 {

    public static Optional<LocalDateTime> validandoDataHora(int ano, int mes, int dia, int hora, int minuto){
        try {
            return Optional.of(LocalDateTime.of(ano,mes,dia,hora,minuto));
        }catch (DateTimeException e){
            System.err.println("Erro, data ou hora inválida:"+e.getMessage());
            return Optional.empty();
        }
    }
}
