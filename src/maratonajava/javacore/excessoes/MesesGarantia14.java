package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia14 extends IllegalArgumentException {
    public static final int GARANTIA_MINIMO = 3;
    public MesesGarantia14() {
        super(String.format("Garantia não pode ser menor que %d.",GARANTIA_MINIMO));
    }
}
