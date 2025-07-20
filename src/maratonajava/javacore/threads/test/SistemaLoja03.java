package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos02;
import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos03;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido03;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos03;

import java.util.concurrent.*;

public class SistemaLoja03 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Pedido03> filaPedido = new LinkedBlockingQueue<>(10);
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThreads);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos03(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos03(filaPedido,executorCalculo));

        Thread.sleep(15000);

        System.out.println("Encerrar o sistema.");
        executorSistema.shutdownNow();
        executorCalculo.shutdownNow();

        executorSistema.awaitTermination(5,TimeUnit.SECONDS);
        executorCalculo.awaitTermination(5,TimeUnit.SECONDS);

        System.out.println("Sistema finalizado");
    }
}
