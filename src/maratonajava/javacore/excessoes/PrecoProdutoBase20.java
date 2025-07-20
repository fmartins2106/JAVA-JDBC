package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase20 extends IllegalArgumentException {
    public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProdutoBase20() {
        super(String.format("Preço não pode ser menor que R$%.2f.",MENOR_PRECO_PRODUTO));
    }
}
