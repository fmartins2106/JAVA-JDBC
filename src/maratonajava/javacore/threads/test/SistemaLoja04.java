package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos04;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido04;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos04;

import java.util.concurrent.*;

public class SistemaLoja04 {

    public static void main(String[] args)throws InterruptedException {
        BlockingQueue<Pedido04> filaPedido = new LinkedBlockingQueue<>(10);
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThreads);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos04(filaPedido));
        executorCalculo.execute(new ConsumidorDePedidos04(filaPedido,executorCalculo));

        Thread.sleep(20000);

        System.out.println("Encerrar o sistema.");
        executorSistema.shutdownNow();
        executorCalculo.shutdownNow();

        executorCalculo.awaitTermination(5,TimeUnit.SECONDS);
        executorSistema.awaitTermination(5,TimeUnit.SECONDS);

        System.out.println("Sistema finalizado.");
    }
}
