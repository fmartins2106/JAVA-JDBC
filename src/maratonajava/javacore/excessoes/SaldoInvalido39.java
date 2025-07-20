package academy.devdojo.maratonajava.javacore.excessoes;

public class SaldoInvalido39 extends IllegalArgumentException {
    public static final double SALDO_MINIMO = 0;
    public SaldoInvalido39() {
        super(String.format("Saldo não pode ser menor que R$%.2f.",SALDO_MINIMO));
    }
}
