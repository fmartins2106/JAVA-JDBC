package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase27 extends IllegalArgumentException {
  public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProdutoBase27() {
        super(String.format("Preço produto não pode ser vazio ou conter caracteres.",MENOR_PRECO_PRODUTO));
    }
}
