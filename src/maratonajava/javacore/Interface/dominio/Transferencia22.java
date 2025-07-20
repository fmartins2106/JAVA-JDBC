package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia22 implements Pagamento22{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia22(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= saldoConta;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            saldoConta -= valor;
            System.out.println("Transferência autorizada no valor de R$"+df.format(valor));
        }else {
            System.out.println("Digite um valor válido.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível para pagamento ->R$"+df.format(saldoConta));
    }
}
