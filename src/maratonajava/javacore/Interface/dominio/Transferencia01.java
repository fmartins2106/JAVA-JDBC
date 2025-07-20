package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia01 implements Pagamento01{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia01(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return true;
    }

    @Override
    public void processarPagamento(double valor){
        System.out.println("Pagamento de R$"+df.format(valor)+" realizado com sucesso.");
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível para transferência:R$"+df.format(saldo));
    }
}
