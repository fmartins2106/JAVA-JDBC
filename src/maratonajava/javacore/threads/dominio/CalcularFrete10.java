package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class CalcularFrete10 implements Callable<BigDecimal> {
    public final BigDecimal valor;

    public CalcularFrete10(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(2000);
        BigDecimal taxaFrete = new BigDecimal("0.05");
        BigDecimal fixo = new BigDecimal("20.00");
        return fixo.add(valor.multiply(taxaFrete).setScale(2, RoundingMode.HALF_UP));
    }
}

