package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto34 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE = 0;
    public EstoqueProduto34() {
        super(String.format("Estoque não pode ser menor que %d.",MENOR_ESTOQUE));
    }
}
