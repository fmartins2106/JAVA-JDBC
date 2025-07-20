package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall12 implements Pagamento12{
    private double saldoPaypall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall12(double saldoPaypall) {
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
            System.out.println("Pagamento de R$"+df.format(valor)+" realizado com sucesso.");
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void saldoDisponivel(){
        System.out.println("Saldo disponível em conta:R$"+df.format(saldoPaypall));
    }
}
