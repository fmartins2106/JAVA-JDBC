package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto45 extends RuntimeException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public EstoqueProduto45() {
        super(String.format("Estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
