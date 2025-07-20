package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase25 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDE_ESTOQUE = 0;
    public QuantidadeProdutoBase25() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MENOR_QUANTIDE_ESTOQUE));
    }
}
