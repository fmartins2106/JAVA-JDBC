package academy.devdojo.maratonajava.javacore.excessoes;

public class NumeroContaInvalida38 extends IllegalArgumentException {
    public static final int DIGITOS_PADRAO_CONTA = 6;
    public NumeroContaInvalida38() {
        super(String.format("Número da conta deve ter %d digitos.",DIGITOS_PADRAO_CONTA));
    }
}
