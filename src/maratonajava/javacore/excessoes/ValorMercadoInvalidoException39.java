package academy.devdojo.maratonajava.javacore.excessoes;

public class ValorMercadoInvalidoException39 extends IllegalArgumentException {
    public static final double MENOR_VALOR_MERCADO = 0;
    public ValorMercadoInvalidoException39() {
        super(String.format("Valor de mercado não pode ser menor que R$%.2f",MENOR_VALOR_MERCADO));
    }
}
