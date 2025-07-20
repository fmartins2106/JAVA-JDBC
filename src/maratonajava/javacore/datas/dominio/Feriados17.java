package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Feriados17 {
    public static Set<LocalDate> gerarFeriados(int ano){
        Set<LocalDate> feriados = new HashSet<>();
        feriados.add(LocalDate.of(ano,1,1));
        feriados.add(LocalDate.of(ano, 4, 21));  // Tiradentes
        feriados.add(LocalDate.of(ano, 5, 1));   // Dia do Trabalho
        feriados.add(LocalDate.of(ano, 9, 7));   // Independência do Brasil
        feriados.add(LocalDate.of(ano, 10, 12)); // Nossa Senhora Aparecida
        feriados.add(LocalDate.of(ano, 11, 2));  // Finados
        feriados.add(LocalDate.of(ano, 11, 15)); // Proclamação da República
        feriados.add(LocalDate.of(ano, 12, 25)); // Natal

        // Feriados móveis
        LocalDate pascoa = calcularPascoa(ano);
        feriados.add(pascoa.minusDays(48)); // Carnaval
        feriados.add(pascoa.minusDays(2));  // Sexta-feira Santa
        feriados.add(pascoa.plusDays(60));  // Corpus Christi

        return feriados;
    }

    public static LocalDate calcularPascoa(int ano) {
        int a = ano % 19;
        int b = ano / 100;
        int c = ano % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int mes = (h + l - 7 * m + 114) / 31;
        int dia = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(ano, mes, dia);
    }

    public static boolean isDiaUtil(LocalDate data){
        Set<LocalDate> feriados = gerarFeriados(data.getYear());
        DayOfWeek diaSemana = data.getDayOfWeek();
        return diaSemana != DayOfWeek.SATURDAY &&
                diaSemana != DayOfWeek.SUNDAY &&
                !feriados.contains(data);
    }

    public static LocalDate ajustarParaProximoDiaUtil(LocalDate date){
        while (!isDiaUtil(date)){
            date = date.plusDays(1);
        }
        return date;
    }

    public static boolean eDiaUtil(LocalDate date){
        Set<LocalDate> feriados = gerarFeriados(date.getYear());
        DayOfWeek diaSemana = date.getDayOfWeek();
        return diaSemana != DayOfWeek.SUNDAY &&
                diaSemana != DayOfWeek.SATURDAY &&
                !feriados.contains(date);
    }

    public static LocalDate ajudarParaProximoDiaUtil(LocalDate date){
        if (!eDiaUtil(date)){
            date = date.plusDays(1);
        }
        return date;
    }

}
