package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall30 implements Pagamento30{
    private double saldoPayapall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall30(double saldoPayapall) {
        this.saldoPayapall = saldoPayapall;
    }

    @Override
    public boolean verificarSaldo(double valor) {
        return valor <= saldoPayapall;
    }

    @Override
    public void processarPagamentos(double valor) {
        if (verificarSaldo(valor)){
            saldoPayapall -= valor;
            System.out.println("Pagamento autorizado no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Pagamento não autorizado.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponível na conta Paypall - R$"+df.format(saldoPayapall));
    }
}
