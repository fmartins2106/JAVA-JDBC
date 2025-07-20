package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall04 implements Pagamento04{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall04(double saldo) {
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
            System.out.println("Saldo disponível para pagamento ->R$"+df.format(saldo));
        }else {
            System.out.println("Operação inválida. Verifique saldo.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível para pagamento -> R$"+df.format(saldo));
    }
}
