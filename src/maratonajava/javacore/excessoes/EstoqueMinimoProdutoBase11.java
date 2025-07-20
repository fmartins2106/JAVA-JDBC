package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase11 extends RuntimeException {
    public static final int MENOR_ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase11() {
        super(String.format("Estoque mínimo não pode ser menor que %d.",MENOR_ESTOQUE_MINIMO));
    }
}
