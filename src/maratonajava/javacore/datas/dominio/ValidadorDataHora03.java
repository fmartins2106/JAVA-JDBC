package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ValidadorDataHora03 {

    public static LocalDateTime validandoDataHora(int ano, int mes, int dia, int horas, int minutos){
        try {
            return LocalDateTime.of(ano,mes,dia,horas,minutos);
        }catch (DateTimeException e){
            System.out.println("Data ou hora inválida.");
        }
        return null;
    }
}
