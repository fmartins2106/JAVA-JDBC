package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase02 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase02() {
        super(String.format("Estoque não pode ser menor que %d.",MENOR_ESTOQUE_MINIMO));
    }
}
