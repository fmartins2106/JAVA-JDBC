package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase12 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE = 0;
    public QuantidadeProdutoBase12() {
        super(String.format("Estoque não pode ser menor que %d.",MENOR_ESTOQUE));
    }
}
