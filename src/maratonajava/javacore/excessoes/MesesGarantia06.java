package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia06 extends IllegalArgumentException {
    public static final int MENOR_GARANTIA = 3;
    public MesesGarantia06() {
        super(String.format("Garantia não pode ser menor que %d.",MENOR_GARANTIA));
    }
}
