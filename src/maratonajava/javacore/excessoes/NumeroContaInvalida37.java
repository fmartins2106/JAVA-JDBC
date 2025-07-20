package academy.devdojo.maratonajava.javacore.excessoes;

public class NumeroContaInvalida37 extends IllegalArgumentException {
    public static final int DIGITOS_PADRAO_CONTA = 6;

    public NumeroContaInvalida37() {
        super(String.format("Número de conta precisa ter %d digitos para ter validade.",DIGITOS_PADRAO_CONTA));
    }
}
