package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class CartaoDeCredito37 implements Pagamento37{
    private double limiteCartao;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito37(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    @Override
    public boolean verificarSaldo(double valor) {
        return valor <= limiteCartao;
    }

    @Override
    public void processarPagamento(double valor) {
        if (verificarSaldo(valor)){
            limiteCartao -= valor;
            System.out.println("Pagamento efetuado no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Operação negada. Verifique valor.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Limite disponível para pagamento:R$"+df.format(limiteCartao));
    }
}
