package academy.devdojo.maratonajava.javacore.excessoes;

public class SaldoInvalido42 extends IllegalArgumentException {
    public static final double MENOR_SALDO_PERMITIDO = 0;
    public SaldoInvalido42() {
        super(String.format("Saldo inválido. Saldo não pode ser menor que R$%.2f.",MENOR_SALDO_PERMITIDO));
    }
}
