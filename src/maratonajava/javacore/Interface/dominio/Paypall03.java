package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall03 implements Pagamento03{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall03(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= saldo;
    }

    @Override
    public void processarPagamento(double valor){
        if (verificarSaldo(valor)){
            saldo -= valor;
            System.out.println("Pagamento de R$"+df.format(valor)+" realizado com sucesso.");
            System.out.println("Saldo do Paypall disponível para pagamento -> R$"+df.format(saldo));
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível na conta Paypall -> R$"+df.format(saldo));
    }
}
