package academy.devdojo.maratonajava.javacore.threads;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos06;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido06;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos06;

import java.sql.Time;
import java.util.concurrent.*;

public class TreinandoSistemaLoja2 {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido06> filaPedido = new LinkedBlockingQueue<>();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcles disponíveis:"+nThreads);

        ExecutorService executorSistema = Executors.newFixedThreadPool(nThreads);
        ExecutorService executorCalculo = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos06(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos06(filaPedido,executorCalculo));

        Thread.sleep(20000);

        System.out.println("Encerrando sistema");

        executorSistema.shutdownNow();
        executorCalculo.shutdownNow();

        executorSistema.awaitTermination(5, TimeUnit.SECONDS);
        executorCalculo.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Sistema finalizado.");
    }
}
