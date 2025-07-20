package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class ValidadorDataHora19 {

    public static LocalDateTime validandoDataHora(int ano, int mes, int dia, int hora, int minuto){
        try {
            return LocalDateTime.of(ano,mes,dia,hora,minuto);
        }catch (DateTimeException e){
            System.out.println("Digite uma data ou hora válida.");
        }
        return null;
    }
}
