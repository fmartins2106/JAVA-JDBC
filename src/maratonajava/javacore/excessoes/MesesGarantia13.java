package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia13 extends IllegalArgumentException {
    public static final int GARANTIA_MINIMA = 3;
    public MesesGarantia13() {
        super(String.format("Garantia não pode ser menor que %d.",GARANTIA_MINIMA));
    }
}
