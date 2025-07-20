package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeDadosProduto extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeDadosProduto() {
        super(String.format("Qunatidade em estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
