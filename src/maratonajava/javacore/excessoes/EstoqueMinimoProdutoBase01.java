package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase01 extends IllegalArgumentException {
    public static final int ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase01() {
        super(String.format("Estoque mínimo não pode ser menor que %d.",ESTOQUE_MINIMO));
    }
}
