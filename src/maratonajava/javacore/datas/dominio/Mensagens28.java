package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class Mensagens28 {

    public static ResourceBundle carregar(String idiomas){
        Locale locale = idiomas.equalsIgnoreCase("en") ? new Locale("en","US") :
                new Locale("pt","BR");
        return ResourceBundle.getBundle("mensagensBundle.messages28",locale);
    }
}
