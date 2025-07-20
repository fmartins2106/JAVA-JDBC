package academy.devdojo.maratonajava.javacore.excessoes;

public class SaldoInvalido40 extends IllegalArgumentException {
    public static final double SALDO_MINIMO = 0;
    public SaldoInvalido40() {
        super(String.format("Saldo da conta não pode ser menor que R$%.2f.",SALDO_MINIMO));
    }
}
