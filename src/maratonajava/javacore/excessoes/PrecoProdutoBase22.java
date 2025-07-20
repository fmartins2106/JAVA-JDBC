package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase22 extends IllegalArgumentException {
    public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProdutoBase22() {
        super(String.format("Menor preço produto:R$%.2f",MENOR_PRECO_PRODUTO));
    }
}
