package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto40 extends IllegalArgumentException{
    public static final int MENOR_ESTOQUE_PRODUTO = 0;
    public EstoqueProduto40() {
        super(String.format("Estoque produto não pode ser menor que %d.",MENOR_ESTOQUE_PRODUTO));
    }
}
