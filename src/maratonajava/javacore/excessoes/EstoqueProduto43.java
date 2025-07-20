package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto43 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public EstoqueProduto43() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
