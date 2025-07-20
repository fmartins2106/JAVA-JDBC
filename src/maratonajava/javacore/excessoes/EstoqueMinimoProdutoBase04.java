package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase04 extends IllegalArgumentException{
    public static final int MENOR_ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase04() {
        super(String.format("Estoque minimo não pode ser menor que %d.",MENOR_ESTOQUE_MINIMO));
    }
}
