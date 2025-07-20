package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.Callable;

public class CalcularImposto01 implements Callable<Double>{
    private final double valor;

    public CalcularImposto01(double valor) {
        this.valor = valor;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(1500);
        return valor * 0.15;
    }
}
/**
 * A interface Callable<T> permite que objetos dessa classe sejam executados por uma thread
 * e retornem um resultado (neste caso, um Double). Diferente da interface Runnable,
 * que não retorna valor e não pode lançar exceções checadas,
 * Callable<T> retorna um valor e pode lançar exceções.
 *
 * Este método call() simula o cálculo de imposto (15% do valor do pedido)
 * e pode ser executado de forma assíncrona utilizando ExecutorService.
 */
