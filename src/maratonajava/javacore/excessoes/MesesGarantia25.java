package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia25 extends IllegalArgumentException {
    public static final int GARANTIA_MINIMA = 3;
    public MesesGarantia25() {
        super(String.format("Garanti não pode ser menor que %d.",GARANTIA_MINIMA));
    }
}
