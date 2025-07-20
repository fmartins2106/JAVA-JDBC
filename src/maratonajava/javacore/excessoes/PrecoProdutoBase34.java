package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase34 extends IllegalArgumentException {
    public static final double MENOR_PRECO = 0;
    public PrecoProdutoBase34() {
        super(String.format("Preço não pode ser menor que R$%.2f",MENOR_PRECO));
    }
}
