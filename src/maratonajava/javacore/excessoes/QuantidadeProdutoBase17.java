package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase17 extends IllegalArgumentException{
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;

    public QuantidadeProdutoBase17() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
