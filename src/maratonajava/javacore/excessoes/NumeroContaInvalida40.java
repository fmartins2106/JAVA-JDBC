package academy.devdojo.maratonajava.javacore.excessoes;

public class NumeroContaInvalida40 extends IllegalArgumentException {
    public static final int DIGITOS_CONTA = 6;
    public NumeroContaInvalida40() {
        super("Número de conta precisa ter %d digitos.Verifique.");
    }
}
