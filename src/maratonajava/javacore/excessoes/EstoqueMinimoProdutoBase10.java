package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase10 extends RuntimeException {
    public static final int ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase10() {
        super(String.format("Estoque mínimo não pode ser menor que %d.",ESTOQUE_MINIMO));
    }
}
