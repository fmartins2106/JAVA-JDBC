package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto44 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE_PRODUTO = 0;
    public EstoqueProduto44() {
        super(String.format("Estoque do produto não pode ser menor que %d.",MENOR_ESTOQUE_PRODUTO));
    }
}
