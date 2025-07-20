package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class ValidadorDataHora31 {

    public static LocalDateTime validandoDataHora(int ano, int mes, int dia, int hora, int minuto){
        try {
            return LocalDateTime.of(ano,mes,dia,hora,minuto);
        }catch (DateTimeException e){
            System.err.print("Erro: Digite uma opção válida:"+e.getMessage());
            return null;
        }
    }
}
