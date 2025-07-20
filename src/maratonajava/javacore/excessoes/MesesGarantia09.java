package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia09 extends IllegalArgumentException {
    public static final int MINIMO_MESES_GARANTIA = 3;
    public MesesGarantia09() {
        super(String.format("Garantia não pode ser menor que %d meses.",MINIMO_MESES_GARANTIA));
    }
}
