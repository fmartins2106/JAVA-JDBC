package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProduto33 extends IllegalArgumentException {
    public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProduto33() {
        super(String.format("Preço não pode ser menor que R$%.2f.",MENOR_PRECO_PRODUTO));
    }
}
