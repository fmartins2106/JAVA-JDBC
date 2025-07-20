package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito03 implements Pagamento03{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito03(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= limiteDisponivel;
    }

    @Override
    public void processarPagamento(double valor){
        if (verificarSaldo(valor)){
            limiteDisponivel -= valor;
            System.out.println("Pagamento de R$"+df.format(valor)+" realizado.");
            System.out.println("Novo limite disponível ->R$"+df.format(limiteDisponivel));
        }else {
            System.out.println("Pagamento falhou. Saldo insuficiente.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite disponível para compra:R$"+df.format(limiteDisponivel));
    }

}
