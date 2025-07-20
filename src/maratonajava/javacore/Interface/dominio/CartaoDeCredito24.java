package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito24 implements Pagamento24{
    private double limiteCartao;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito24(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= limiteCartao;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            limiteCartao -= valor;
            System.out.println("Pagamento autorizado no valor de R$"+df.format(valor));
        }else {
            System.out.println("Valor inválido");
        }
    }

    public void consultarSaldo(){
        System.out.println("Limite disponível para pagamento:R$"+df.format(limiteCartao));
    }
}
