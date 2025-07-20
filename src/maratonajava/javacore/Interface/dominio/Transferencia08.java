package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia08 implements Pagamento08{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia08(double saldoConta) {
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
            System.out.println("Transferência no valor de R$"+df.format(valor)+" realizada com sucesso.");
        }else {
            System.out.println("Valor inválido. Verifique valor.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível para transferência ->R$"+df.format(saldoConta));
    }
}
