package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase25 extends IllegalArgumentException {
    public static final int MENOR_VALOR_PRODUTO = 0;
    public PrecoProdutoBase25() {
        super(String.format("Preço produto não pode ser menor que R$%.2f",MENOR_VALOR_PRODUTO));
    }
}
