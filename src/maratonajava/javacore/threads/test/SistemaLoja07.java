package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.CalcularImposto07;
import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos07;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido07;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos07;

import java.util.concurrent.*;

public class SistemaLoja07 {

    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido07> filaPedido = new LinkedBlockingQueue<>();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcles disponíveis:"+nThreads);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos07(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos07(filaPedido,executorCalculo));

        Thread.sleep(20000);

        executorCalculo.shutdownNow();
        executorSistema.shutdownNow();

        System.out.println("Encerrar sistema.");
        executorSistema.awaitTermination(5, TimeUnit.SECONDS);
        executorCalculo.awaitTermination(5,TimeUnit.SECONDS);

        System.out.println("Sistema finalizado.");
    }
}
