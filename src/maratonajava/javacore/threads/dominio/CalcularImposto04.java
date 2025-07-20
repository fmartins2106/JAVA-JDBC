package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.Callable;

public class CalcularImposto04 implements Callable<Double> {
    public final double valor;

    public CalcularImposto04(double valor) {
        this.valor = valor;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(1500);
        return valor * 0.15;
    }
}
