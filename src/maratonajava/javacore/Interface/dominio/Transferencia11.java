package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Transferencia11 implements Pagamento11{
    private double saldoConta;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Transferencia11(double saldoConta) {
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
            System.out.println("Pagamento de R$"+df.format(valor)+" realizado com sucesso.");
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível em conta -> R$"+df.format(saldoConta));
    }
}
