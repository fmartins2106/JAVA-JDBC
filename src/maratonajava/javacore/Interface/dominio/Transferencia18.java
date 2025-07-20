package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia18 implements Pagamento18{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia18(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= saldoConta;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            saldoConta -= valor;
            System.out.println("Pagamento no valor de R$"+df.format(valor)+" realizado com sucesso.");
        }else{
            System.out.println("Pagamento inválido. Verifique saldo da conta.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível para pagamento ->R$"+df.format(saldoConta));
    }
}
