package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia03 extends IllegalArgumentException {
    public static final int MESES_GARANTIA = 3;
    public MesesGarantia03() {
        super(String.format("Garantia não pode ser menor que %d meses",MESES_GARANTIA));
    }
}
