package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.Callable;

public class CalcularImposto03 implements Callable<Double> {
    private final double valor;

    public CalcularImposto03(double valor) {
        this.valor = valor;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(2000);
        return valor * 0.015;
    }
}
