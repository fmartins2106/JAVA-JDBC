package academy.devdojo.maratonajava.javacore.excessoes;

public class NumeroContaInvalida41 extends IllegalArgumentException {
    public static final int DIGITOS_NUMERO_CONTA = 6;
    public NumeroContaInvalida41() {
        super(String.format("Número de conta precisa ter %d digitos para ser validada.",DIGITOS_NUMERO_CONTA));
    }
}
