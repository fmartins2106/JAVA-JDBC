package academy.devdojo.maratonajava.javacore.excessoes;

import java.time.Year;

public class AnoFabricacaoException41 extends IllegalArgumentException {
    public static final int MENOR_ANO_FABRICACAO = 1900;
    public static final int MAIOR_ANO_FABRICACAO = Year.now().getValue();
    public AnoFabricacaoException41() {
        super(String.format("Ano de faricação não pode ser menor que %d ou maior que %d.",MENOR_ANO_FABRICACAO,MAIOR_ANO_FABRICACAO));
    }
}
