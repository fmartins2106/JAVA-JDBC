package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia03 implements Pagamento03{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia03(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return  valor <= saldo;
    }

    @Override
    public void processarPagamento(double valor){
        if (verificarSaldo(valor)){
            saldo -= valor;
            System.out.println("Transferência de R$"+df.format(valor)+"realizado com sucesso.");
            System.out.println("Novo saldo disponível em conta -> R$"+df.format(saldo));
        }else {
            System.out.println("Operação negada. Saldo insuficiente.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível para transferência -> R$"+df.format(saldo));
    }


}
