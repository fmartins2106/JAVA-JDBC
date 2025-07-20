package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito05 implements Pagamento05{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito05(double limiteDisponivel) {
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
            System.out.println("Limite disponível após a compra:R$"+df.format(limiteDisponivel));
        }else {
            System.out.println("Verifique valor. Valor não pode ser maior que limite.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite disponível para compra:R$"+df.format(limiteDisponivel));
    }
}
