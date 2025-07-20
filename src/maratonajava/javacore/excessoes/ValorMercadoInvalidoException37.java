package academy.devdojo.maratonajava.javacore.excessoes;

import java.util.IllformedLocaleException;

public class ValorMercadoInvalidoException37 extends IllformedLocaleException {
    public static final double MENOR_VALOR_MERCADO = 0;
    public ValorMercadoInvalidoException37() {
        super(String.format("Valor de mercado não pode ser menor que R$%.2f",MENOR_VALOR_MERCADO));
    }
}
