package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase09 extends IllegalArgumentException {
    public static final int MEMOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase09() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MEMOR_QUANTIDADE_ESTOQUE));
    }
}
