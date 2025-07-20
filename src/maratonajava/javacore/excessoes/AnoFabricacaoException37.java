package academy.devdojo.maratonajava.javacore.excessoes;

import java.time.Year;
import java.util.IllformedLocaleException;

public class AnoFabricacaoException37 extends IllformedLocaleException {
    public static final int MENOR_ANO_FABRICACAO = 1900;
    public static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();
    public AnoFabricacaoException37() {
        super(String.format("Ano de fabricação não pode ser menor que %d ou maior que %d.",MENOR_ANO_FABRICACAO,MAIOR_ANO_FABRICACAO));
    }
}
