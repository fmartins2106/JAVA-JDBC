package academy.devdojo.maratonajava.javacore.datas.dominio;


import java.time.DateTimeException;
import java.time.LocalDateTime;


public class ValidadorDataHora01 {

    public static LocalDateTime validarDataHora(int ano, int mes, int dia,int hora ,int minutos){
        try {
            return LocalDateTime.of(ano,mes,dia,hora,minutos);
        }catch (DateTimeException e){
            System.out.println("Data e hora inválida.");
        }
        return null;
    }
}
