package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase06 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE = 0;
    public QuantidadeProdutoBase06() {
        super(String.format("Quantidade não pode ser menor que %d.",MENOR_QUANTIDADE));
    }
}
