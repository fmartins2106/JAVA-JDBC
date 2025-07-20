package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia27 implements Pagamento27{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia27(double saldoConta) {
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
            System.out.println("Transferência no valor de R$"+df.format(valor)+" autorizada com sucesso.");
            return;
        }
        System.out.println("Operação negada. Valor não pode ser maior que saldo.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponível em conta - > R$"+df.format(saldoConta));
    }
}
