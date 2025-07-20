package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall37 implements Pagamento37{
    private double saldoPaypall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall37(double saldoPaypall) {
        this.saldoPaypall = saldoPaypall;
    }

    @Override
    public boolean verificarSaldo(double valor) {
        return valor <= saldoPaypall;
    }

    @Override
    public void processarPagamento(double valor) {
        if (verificarSaldo(valor)){
            saldoPaypall -= valor;
            System.out.println("Pagamento efetuado no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Pagamento não autorizado. Verifique valor.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponível na conta Paypall.R$"+df.format(saldoPaypall));
    }
}
