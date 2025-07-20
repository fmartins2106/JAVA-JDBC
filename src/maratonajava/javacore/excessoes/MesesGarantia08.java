package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia08 extends IllegalArgumentException {
    public static final int MESES_GARANTIA_MINIMA = 3;
    public MesesGarantia08() {
        super(String.format("Garantia não pode ser menor que %d.",MESES_GARANTIA_MINIMA));
    }
}
