package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase09 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase09() {
        super(String.format("Estoque mínimo não pode ser menor que %d",MENOR_ESTOQUE_MINIMO));
    }
}
