package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto23 extends IllegalArgumentException {
  public static final int ESTOQUE_MINIMO = 0;
    public EstoqueProduto23() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",ESTOQUE_MINIMO));
    }
}
