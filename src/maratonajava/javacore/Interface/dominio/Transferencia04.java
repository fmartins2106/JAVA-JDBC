package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia04 implements Pagamento04{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia04(double saldo) {
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
            System.out.println("Pagamento de -> R$"+df.format(valor));
            System.out.println("Saldo disponível R$"+df.format(saldo));
        }else {
            System.out.println("Valor inválido. Verifique saldo.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponivel ->R$"+df.format(saldo));
    }

}
