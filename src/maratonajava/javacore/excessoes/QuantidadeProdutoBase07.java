package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase07 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE = 0;
    public QuantidadeProdutoBase07() {
        super(String.format("Quantidade não pode ser menor que %d.",MENOR_QUANTIDADE));
    }
}
