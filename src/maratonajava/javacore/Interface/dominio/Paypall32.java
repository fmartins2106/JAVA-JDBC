package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall32 implements Pagamento32{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall32(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    @Override
    public boolean verificarSaldo(double valor) {
        return valor <= saldoConta;
    }

    @Override
    public void processarPagamentos(double valor) {
        if (verificarSaldo(valor)){
            saldoConta -= valor;
            System.out.println("Pagamento autorizado no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Pagamento não autorizado. Verifique valor.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponível na conta Paypall.R$"+df.format(saldoConta));
    }
}
