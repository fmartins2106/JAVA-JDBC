package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase33 extends IllegalArgumentException {
    public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProdutoBase33() {
        super(String.format("Preço do produto não pode ser vazio ou conter caracteres."));
    }
}
