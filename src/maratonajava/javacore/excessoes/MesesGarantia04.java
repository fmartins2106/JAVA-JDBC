package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia04 extends IllegalArgumentException {
    public static final int MINIMO_MESES_GARANTIA = 3;
    public MesesGarantia04() {
        super(String.format("Garantia não pode ser menor que %d meses de garantia.",MINIMO_MESES_GARANTIA));
    }
}
