package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia02 extends IllegalArgumentException {
  public static final int MINIMO_MESES_GARANTIA = 3;
    public MesesGarantia02() {
        super(String.format("Garantia não pode ser menor que %d.",MINIMO_MESES_GARANTIA));
    }
}
