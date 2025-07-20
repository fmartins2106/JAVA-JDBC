package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall19 implements Pagamento19{
    private double saldoPaypall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall19(double saldoPaypall) {
        this.saldoPaypall = saldoPaypall;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= saldoPaypall;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            saldoPaypall -= valor;
            System.out.println("Pagamento no valor de R$"+df.format(valor)+" realizado com sucesso.");
        }else {
            System.out.println("Operação negada. Verifique valor.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo atualizado da conta Paypall -> R$"+df.format(saldoPaypall));
    }
}
