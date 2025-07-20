package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito01 implements Pagamento01{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito01(double limiteDisponivel) {
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
            System.out.println("Pagamento de R$"+df.format(valor)+ "realizado com sucesso.");
            System.out.println("Novo limite disponivel:R$"+df.format(limiteDisponivel));
        }else {
            System.out.println("Pagamenoto falou liminte insuficiente.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite disponível no cartão de crédito:R$"+df.format(limiteDisponivel));
    }



}
