package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoDadosProduto extends IllegalArgumentException {
    public static final double MENOR_PRECO = 0;
    public PrecoDadosProduto() {
        super(String.format("Preço não pode ser menor que R$%.2f",MENOR_PRECO));
    }
}
