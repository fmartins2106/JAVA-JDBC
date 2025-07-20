package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class ValidadorDataHora02 {

    public static LocalDateTime validarHora(int ano,int mes, int dia, int hora, int minutos){
        try {
            return LocalDateTime.of(ano,mes,dia,hora,minutos);
        }catch (DateTimeException e){
            System.out.println("Data inválida.");
        }
        return null;
    }
}
