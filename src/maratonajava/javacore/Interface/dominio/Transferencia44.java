package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia44 implements Pagamento44{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia44(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    @Override
    public boolean verificarSaldo(double valor) {
        return valor <= saldoConta;
    }

    @Override
    public void processarPagamento(double valor) {
        if (verificarSaldo(valor)){
            saldoConta -= valor;
            System.out.println("Pagamento autorizado no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Pagamento não autorizado. Vefifique valor.");
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Saldo disponível em conta:R$"+df.format(saldoConta));
    }
}
