package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class CalcularImposto11 implements Callable<BigDecimal> {
    public final BigDecimal valor;

    public CalcularImposto11(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(1500);
        BigDecimal percentual = new BigDecimal("0.15");
        return valor.multiply(percentual).setScale(2, RoundingMode.HALF_UP);
    }
}
