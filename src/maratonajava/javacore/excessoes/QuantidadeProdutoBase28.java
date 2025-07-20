package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase28 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase28() {
        super(String.format(String.format("Quantidade não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE)));
    }
}
