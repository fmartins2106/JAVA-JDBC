package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall07 implements Pagamento07{
    private double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall07(double saldo) {
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
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível em conta:R$"+df.format(saldo));
    }

}
