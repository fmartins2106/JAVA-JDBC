package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos05;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido05;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos05;

import java.util.concurrent.*;

public class SistemaLoja05 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Pedido05> filaPedido = new LinkedBlockingQueue<>();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThreads);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos05(filaPedido));
        executorCalculo.execute(new ConsumidorDePedidos05(filaPedido,executorCalculo));

        Thread.sleep(20000);

        System.out.println("Encerrar  sistema.");

        executorSistema.shutdownNow();
        executorCalculo.shutdownNow();

        executorCalculo.awaitTermination(5, TimeUnit.SECONDS);
        executorSistema.awaitTermination(5,TimeUnit.SECONDS);

        System.out.println("Sistema finalizado.");
    }
}
