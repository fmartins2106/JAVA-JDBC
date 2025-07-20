package academy.devdojo.maratonajava.javacore.excessoes;

public class NumeroContaInvalida42 extends IllegalArgumentException {
    public static final int DIGITOS_CONTA = 6;
    public NumeroContaInvalida42() {
        super(String.format("Conta precisa ter %d digitos para ter validade.",DIGITOS_CONTA));
    }
}
