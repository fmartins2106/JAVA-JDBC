package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos06;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido06;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos06;

import java.sql.Time;
import java.util.concurrent.*;

public class SistemaLoja06 {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido06> filaPedido = new LinkedBlockingQueue<>();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThreads);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos06(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos06(filaPedido, executorCalculo));

        Thread.sleep(20000);

        System.out.println("Encerrar o sistema.");

        executorSistema.shutdownNow();
        executorCalculo.shutdownNow();

        executorCalculo.awaitTermination(5, TimeUnit.SECONDS);
        executorSistema.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Sistema finalizado.");
    }
}
