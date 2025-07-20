package academy.devdojo.maratonajava.javacore.stream.validacao;

public class QuantidadeValidacaoProdutoStream extends IllegalArgumentException {
  public static final int QUANTIDADE_MINIMA = 0;
  public QuantidadeValidacaoProdutoStream() {
        super(String.format("Quantidade não pode ser menor que %d.",QUANTIDADE_MINIMA));
    }
}
