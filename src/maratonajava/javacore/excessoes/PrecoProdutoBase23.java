package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase23 extends IllegalArgumentException {
    public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProdutoBase23() {
        super(String.format("Preço do produto não pode ser menor que R$%.2f.",MENOR_PRECO_PRODUTO));
    }
}
