package academy.devdojo.maratonajava.javacore.excessoes;

public class SaldoInvalido41 extends IllegalArgumentException {
    public static final double SALDO_MINIMO = 0;
    public SaldoInvalido41() {
        super(String.format("Saldo inválido. Saldo não pode ser menor que R$%.2f.",SALDO_MINIMO));
    }
}
