package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase01 extends IllegalArgumentException{
    public static final int MENOR_ESTOQUE = 0;
    public QuantidadeProdutoBase01() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MENOR_ESTOQUE));
    }
}
