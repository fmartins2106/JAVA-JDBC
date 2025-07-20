package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase20 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase20() {
        super(String.format("Quantidade não pode ser menor que R$%.2f",MENOR_QUANTIDADE_ESTOQUE));
    }
}
