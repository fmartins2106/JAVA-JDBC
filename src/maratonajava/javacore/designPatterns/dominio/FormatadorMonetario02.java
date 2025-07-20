package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorMonetario02 {
    private static final Locale LOCALE_BRASIL = new Locale("pt","BR");
    private static final NumberFormat FORMATADOR_MOEDA = NumberFormat.getCurrencyInstance(LOCALE_BRASIL);

//    Metodo para formatar BigDecimal como moeda brasileira;

    public static String formatar(BigDecimal valor){
        return FORMATADOR_MOEDA.format(valor);
    }

//    PARA QUANDO NÃO PRECISAR USAR BIGDECIMAL.
    public static String formatar(double valor){
        return FORMATADOR_MOEDA.format(valor);
    }
}
