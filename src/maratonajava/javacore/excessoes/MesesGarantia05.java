package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia05 extends IllegalArgumentException {
    public static final int MINIMO_GARANTIA = 3;
    public MesesGarantia05() {
        super(String.format("Garantia não pode ser menor que %d meses.",MINIMO_GARANTIA));
    }
}
