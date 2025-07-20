package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia16 extends IllegalArgumentException {
    public static final int GARANTIA_MINIMA = 3;
    public MesesGarantia16() {
        super(String.format("Garantia não pode ser menor que %d.",GARANTIA_MINIMA));
    }
}
