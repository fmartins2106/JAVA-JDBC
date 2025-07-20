package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia23 extends IllegalArgumentException {
    public static final int GARANTIA_MINIMA = 3;
    public MesesGarantia23() {
        super(String.format("Garantia não pode ser menor que R$%.2f.",GARANTIA_MINIMA));
    }
}
