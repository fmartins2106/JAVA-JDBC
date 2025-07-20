package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito40 implements Pagamento40{
    private double limiteCartao;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito40(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    @Override
    public boolean verificarSaldo(double valor) {
        return valor <= limiteCartao;
    }

    @Override
    public void processarPagamentos(double valor) {
        if (verificarSaldo(valor)){
            limiteCartao -= valor;
            System.out.println("Pagamento autorizado no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Pagamento não autorizado. Verifique valor.");
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Limite disponível para pagamento:R$"+df.format(limiteCartao));
    }
}
