package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProduto30 extends IllegalArgumentException {
    public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProduto30() {
        super(String.format("Preço produto não pode ser menor que R$%.2f.",MENOR_PRECO_PRODUTO));
    }
}
