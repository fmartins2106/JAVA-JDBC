package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.Callable;

public class CalcularFrete02 implements Callable<Double> {
    private final double valor;

    public CalcularFrete02(double valor) {
        this.valor = valor;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(1500);
        return 20 + (valor * 0.05);
    }
}
