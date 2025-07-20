package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida34;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Optional;

public class ValidadorDataHora34 {

    public static Optional<LocalDateTime> validandoDataHora(int ano, int mes, int dia, int hora, int minuto) {
        try {
            return Optional.of(LocalDateTime.of(ano,mes,dia,hora,minuto));
        }catch (DateTimeException e){
            System.err.println("Erro. Data inválida."+e.getMessage());
            return Optional.empty();
        }
    }
}
