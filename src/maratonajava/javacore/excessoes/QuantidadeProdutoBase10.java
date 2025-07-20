package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase10 extends RuntimeException {
    public static final int QUANTIDADE_MINIMO_ESTOQUE = 0;
    public QuantidadeProdutoBase10() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",QUANTIDADE_MINIMO_ESTOQUE));
    }
}
