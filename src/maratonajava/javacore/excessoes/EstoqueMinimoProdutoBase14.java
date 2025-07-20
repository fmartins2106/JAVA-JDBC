package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase14 extends IllegalArgumentException {
    public static final int ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase14() {
        super(String.format("Estoque não pode ser menor que %d.",ESTOQUE_MINIMO));
    }
}
