package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase22 extends RuntimeException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase22() {
        super(String.format("Quantidade não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
