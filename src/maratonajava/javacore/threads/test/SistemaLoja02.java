package academy.devdojo.maratonajava.javacore.threads.test;
import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos02;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido02;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos02;

import java.util.concurrent.*;

public class SistemaLoja02 {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido02> filaPedidos = new LinkedBlockingQueue<>(10);
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThreads);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads);

        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos02(filaPedidos));
        executorSistema.execute(new ConsumidorDePedidos02(filaPedidos,executorCalculo));

        Thread.sleep(15000);

        System.out.println("Encerrar sistema.");
        executorSistema.shutdownNow();
        executorCalculo.shutdownNow();

        executorSistema.awaitTermination(5, TimeUnit.SECONDS);
        executorCalculo.awaitTermination(5,TimeUnit.SECONDS);

        System.out.println("Sistema finalizado.");

    }
}
