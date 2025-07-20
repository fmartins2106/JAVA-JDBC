package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall06 implements Pagamento06{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall06(double saldo) {
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
            System.out.println("Pagamento de R$"+df.format(valor)+" realizado com sucesso.");
            System.out.println("Saldo na conta Paypall -> R$"+df.format(saldo));
        }else {
            System.out.println("Valor inválido. Verifique.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Valor atualizado disponível para pagamento na conta Paypall ->R$"+saldo);
    }
}
