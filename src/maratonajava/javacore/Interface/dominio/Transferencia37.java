package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia37 implements Pagamento37{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia37(double saldoConta) {
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
            System.out.println("Pagamento realiado no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Operação negada. Verifique valor.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponível em conta:R$"+df.format(saldoConta));
    }
}
