package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito22 implements Pagamento22{
    private double limiteCartaoCredito;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito22(double limiteCartaoCredito) {
        this.limiteCartaoCredito = limiteCartaoCredito;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= limiteCartaoCredito;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            limiteCartaoCredito -= valor;
            System.out.println("Pagamento autorizado no valor de R$"+df.format(valor));
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Limite disponível no cartão ->R$"+df.format(limiteCartaoCredito));
    }
}
