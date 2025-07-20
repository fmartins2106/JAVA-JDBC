package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase05 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE = 0;
    public QuantidadeProdutoBase05() {
        super(String.format("Quantidade não pode ser menor que %d",MENOR_QUANTIDADE));
    }
}
