package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase23 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase23() {
        super(String.format("Estoque mínimo não pode ser menor que R$%.2f.",MENOR_ESTOQUE_MINIMO));
    }
}
