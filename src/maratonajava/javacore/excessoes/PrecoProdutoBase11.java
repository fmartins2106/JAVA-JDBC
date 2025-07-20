package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase11 extends IllegalArgumentException {
    public static final double PRECO_MINIMO = 0;
    public PrecoProdutoBase11() {
        super(String.format("Preço não pode ser menor que R$%.2f.",PRECO_MINIMO));
    }
}
