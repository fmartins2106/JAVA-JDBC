package academy.devdojo.maratonajava.javacore.excessoes;

public class ValorMercadoInvalidoExcepiton33 extends IllegalArgumentException {
  public static final double VALOR_MERCADO = 0;
  public ValorMercadoInvalidoExcepiton33() {
        super(String.format("Valor de mercado não pode ser menor que R$%.2f",VALOR_MERCADO));
    }
}
