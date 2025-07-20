package academy.devdojo.maratonajava.javacore.threads.validacao;

import java.math.BigDecimal;

public class ValidacaoValorPedido01 extends IllegalArgumentException {
    public static final double MENOR_VALOR_PRODUTO = 0;
    public ValidacaoValorPedido01() {
        super(String.format("Pedido não pode ser menor que R$%.2f.",MENOR_VALOR_PRODUTO));
    }
}
