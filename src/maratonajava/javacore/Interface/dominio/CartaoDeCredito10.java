package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito10 implements Pagamento10{
    private double limiteDisponivel;
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public CartaoDeCredito10(double limiteDisponivel) {
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
            System.out.println("Pagamento realizando no valor de R$"+df.format(valor));
        }else {
            System.out.println("Valor inválido. Verifique !");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite disponível para compra:R$"+df.format(limiteDisponivel));
    }

}
