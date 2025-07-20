package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall01 implements Pagamento01{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall01(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <=saldo;
    }

    @Override
    public void processarPagamento(double valor){
        if (verificarSaldo(valor)){
            saldo -= valor;
            System.out.println("Pagamento de R$"+df.format(valor)+" realizado com sucesso.");
            System.out.println("Novo saldo disponivel no Paypal:R$"+df.format(saldo));
        }else {
            System.out.println("Pagamento falhou. Saldo insuficiente.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível no Payapal:R$"+df.format(saldo));
    }
}
