package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto28 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public EstoqueProduto28() {
        super(String.format("Estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
