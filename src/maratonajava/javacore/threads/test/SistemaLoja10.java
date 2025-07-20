package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos10;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido10;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos10;

import java.util.concurrent.*;

public class SistemaLoja10 {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido10> filaPedido = new LinkedBlockingQueue<>();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThreads);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos10(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos10(filaPedido,executorCalculo));

        Thread.sleep(20000);

        executorSistema.shutdownNow();

        while (!filaPedido.isEmpty()){
            Thread.sleep(500);
        }

        executorSistema.shutdownNow();
        if (!executorCalculo.awaitTermination(5, TimeUnit.SECONDS)){
            System.out.println("Forçando encerramento do cálculo....");
            executorCalculo.shutdownNow();
        }
        System.out.println("Sistema encerrado.");
        executorSistema.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println("Sistema finalizado.");




    }
}
