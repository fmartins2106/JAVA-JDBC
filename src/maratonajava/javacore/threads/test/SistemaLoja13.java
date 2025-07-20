package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos13;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido13;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos13;

import java.util.concurrent.*;

public class SistemaLoja13 {

    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido13> filaPedido = new LinkedBlockingQueue<>();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcles disponíveis:"+nThreads);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos13(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos13(filaPedido,executorCalculo));

        Thread.sleep(20000);

        executorCalculo.shutdownNow();
        while (!filaPedido.isEmpty()){
            Thread.sleep(500);
        }

        executorSistema.shutdownNow();
        if (!executorCalculo.awaitTermination(5, TimeUnit.SECONDS)){
            System.out.println("Forçando encerramento do sistema...");
            executorSistema.shutdownNow();
        }

        System.out.println("Sistema encerrado.");
        executorSistema.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println("Sistema finalizado.");
    }
}
