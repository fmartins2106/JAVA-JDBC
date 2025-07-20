package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito14 implements Pagamento14{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito14(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= limiteDisponivel;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            limiteDisponivel -= valor;
            System.out.println("Pagamento no valor de R$"+df.format(valor)+" realizado com sucesso.");
        }else {
            System.out.println("Valor inválido. Digite um valor válido.");
        }
    }

    @Override
    public void saldoDisponivel(){
        System.out.println("Saldo disponível para pagamento ->R$"+df.format(limiteDisponivel));
    }
}
