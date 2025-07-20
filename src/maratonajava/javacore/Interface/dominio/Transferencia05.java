package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia05 implements Pagamento05{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia05(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public boolean verificarSaldo(double valor){
        return valor <= saldoConta;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            saldoConta -= valor;
            System.out.println("Saque de R$"+df.format(valor)+" realizado com sucesso.");
            System.out.println("Saldo dispónivel em conta após saque:R$"+df.format(saldoConta));
        }else {
            System.out.println("Valor inválido.");
        }
    }

   @Override
    public void consultarSaldo(){
       System.out.println("Saldo disponível para saque:R$"+df.format(saldoConta));
   }
}
