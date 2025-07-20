package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito04 implements Pagamento04{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito04(double limiteDisponivel) {
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
            System.out.println("Pagamento de R$"+df.format(valor)+" realizado com sucesso.");
            System.out.println("Limite atualizado disponível para compra -> R$"+df.format(limiteDisponivel));
        }else {
            System.out.println("Pagamento falhou. Limite insuficiente.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite disponível para compras:R$"+df.format(limiteDisponivel));
    }
}




