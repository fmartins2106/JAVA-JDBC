package academy.devdojo.maratonajava.javacore.excessoes;

public class SaldoInvalido38 extends IllegalArgumentException {
    public static final double SALDO_MINIMO = 0;
    public SaldoInvalido38() {
        super(String.format("Saldo não pode ser menor que R$%.2f.",SALDO_MINIMO));
    }
}
