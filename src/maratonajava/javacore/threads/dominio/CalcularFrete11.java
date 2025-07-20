package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class CalcularFrete11 implements Callable<BigDecimal> {
    public final BigDecimal valor;

    public CalcularFrete11(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(2000);
        BigDecimal taxa = new BigDecimal("20.00");
        BigDecimal percentual = new BigDecimal("0.05");
        return taxa.add(valor.multiply(percentual).setScale(2,RoundingMode.HALF_UP));
    }
}
