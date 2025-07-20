package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase28 extends IllegalArgumentException {
    public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProdutoBase28() {
        super(String.format("Preço do produto não pode ser menor que R$%.2f.",MENOR_PRECO_PRODUTO));
    }
}
