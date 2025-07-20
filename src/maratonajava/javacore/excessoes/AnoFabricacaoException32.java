package academy.devdojo.maratonajava.javacore.excessoes;

import java.time.Year;

public class AnoFabricacaoException32 extends IllegalArgumentException {
    public static final int MENOR_ANO = 1900;
    public static final int MAIOR_ANO = Year.now().getValue();
    public AnoFabricacaoException32() {
        super(String.format("Ano de fabricação não pode ser menor que %d ou maior que %d.",MENOR_ANO,MAIOR_ANO));
    }
}
