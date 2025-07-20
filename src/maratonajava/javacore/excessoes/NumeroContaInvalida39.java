package academy.devdojo.maratonajava.javacore.excessoes;

public class NumeroContaInvalida39 extends IllegalArgumentException {
    public static final int DIGITOS_NUMERO_CONTA = 6;
    public NumeroContaInvalida39() {
        super(String.format("Número da conta deve ter %d digitos.",DIGITOS_NUMERO_CONTA));
    }
}
