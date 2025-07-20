package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class CalcularFrete12 implements Callable<BigDecimal> {
    public final BigDecimal valor;

    public CalcularFrete12(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(2000);
        BigDecimal percentual = new BigDecimal("0.05");
        BigDecimal taxaFixa = new BigDecimal("20.00");
        return valor.multiply(percentual).add(taxaFixa).setScale(2, RoundingMode.HALF_UP);
    }
}
