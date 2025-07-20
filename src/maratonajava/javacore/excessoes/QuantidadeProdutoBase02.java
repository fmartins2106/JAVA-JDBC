package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase02 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE = 0;
    public QuantidadeProdutoBase02() {
        super(String.format("Estoque não pode ser meno que %d",MENOR_ESTOQUE));
    }
}
