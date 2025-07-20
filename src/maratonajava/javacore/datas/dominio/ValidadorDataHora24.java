package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class ValidadorDataHora24 {

    public static LocalDateTime validandoDataValidade(int ano, int mes, int dia, int hora, int minuto){
        try {
            return LocalDateTime.of(ano,mes,dia,hora, minuto);
        }catch (DateTimeException e){
            System.out.println("Erro. Data ou hora inválida.");
        }
        return null;
    }
}
