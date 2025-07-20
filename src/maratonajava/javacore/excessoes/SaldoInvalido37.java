package academy.devdojo.maratonajava.javacore.excessoes;

public class SaldoInvalido37 extends IllegalArgumentException {
    public static final double SALDO_NIMIMO = 0;
    public SaldoInvalido37() {
        super(String.format("Saldo não pode ser menor que R$%.2f.",SALDO_NIMIMO));
    }
}
