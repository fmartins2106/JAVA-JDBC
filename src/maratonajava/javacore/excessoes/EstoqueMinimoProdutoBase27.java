package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase27 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase27() {
        super(String.format("Campo etoque mínimo não pode ser menor que %d.",MENOR_ESTOQUE_MINIMO));
    }
}
