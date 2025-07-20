package academy.devdojo.maratonajava.javacore.Interface.dominio;

import javax.swing.*;
import java.text.DecimalFormat;

public class CartaoDeCredito41 implements Pagamento41{
    private double limiteCartao;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public CartaoDeCredito41(double limiteCartao) {
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
    public void consultarSaldo() {
        System.out.println("Limite disponível:R$"+df.format(limiteCartao));
    }
}
