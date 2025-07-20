package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia06 implements Pagamento06{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia06(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= saldo;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            saldo -= valor;
            System.out.println("Transferência realizada no valor de R$"+df.format(valor));
            System.out.println("Novo saldo disponível para pagamento R$"+df.format(saldo));
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível em conta ->R$"+df.format(saldo));
    }
}
