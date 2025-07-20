package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.util.Locale;
import java.util.ResourceBundle;

public class Mensagens02 {
    public static ResourceBundle carregar(String idioma){
        Locale locale = idioma.equalsIgnoreCase("en") ? new Locale("en", "US") :
                new Locale("pt","BR");
        return ResourceBundle.getBundle("mensagensBundle.messages02",locale);
    }
}
