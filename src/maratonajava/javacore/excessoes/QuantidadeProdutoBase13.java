package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase13 extends IllegalArgumentException {
  public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase13() {
        super(String.format("Quantidade não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
