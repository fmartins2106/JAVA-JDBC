package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class CalcularImposto13 implements Callable<BigDecimal> {
    public final BigDecimal valor;

    public CalcularImposto13(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(1500);
        BigDecimal taxa = new BigDecimal("0.15");
        return valor.multiply(taxa).setScale(2,RoundingMode.HALF_UP);
    }
}
