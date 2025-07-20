package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase24 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase24() {
        super(String.format("Estoque não pode ser menor que R$%.2f.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
