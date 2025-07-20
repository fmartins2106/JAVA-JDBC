package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProduto25 extends IllegalArgumentException {
    public static final double MENOR_PRECO = 0;
    public PrecoProduto25() {
        super(String.format("Preço do produto não pode ser menor que R$%.2f",MENOR_PRECO));
    }
}
