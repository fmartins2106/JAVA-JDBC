package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto24 extends IllegalArgumentException {
    public static final int ESTOQUE_MINIMO = 0;
    public EstoqueProduto24() {
        super(String.format("Estoque não pode ser menor que %d.",ESTOQUE_MINIMO));
    }
}
