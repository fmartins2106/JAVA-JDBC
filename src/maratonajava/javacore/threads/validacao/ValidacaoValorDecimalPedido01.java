package academy.devdojo.maratonajava.javacore.threads.validacao;

import java.math.BigDecimal;

public class ValidacaoValorDecimalPedido01 extends IllegalArgumentException {
    public static final BigDecimal MENOR_VALOR = BigDecimal.valueOf(0);
    public ValidacaoValorDecimalPedido01() {
        super(String.format("Valor não pode ser menor que R$%.2f",MENOR_VALOR));
    }
}
