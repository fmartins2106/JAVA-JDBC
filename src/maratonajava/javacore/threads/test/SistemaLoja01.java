package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido01;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos01;

import java.util.concurrent.*;

public class SistemaLoja01 {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido01> filaPedidos = new LinkedBlockingQueue<>(10);
        // Executor para cálculo de imposto e frete (threads paralelas)
        int nThreads = Runtime.getRuntime().availableProcessors(); // número de núcleos da CPU
        System.out.println("🧠 Núcleos disponíveis: " + nThreads); // apenas para ver no console (opcional)

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThreads); // cria pool com base nos núcleos


        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        //Iniciar produtos e consumidor

        executorSistema.execute(new ProdutorDePedidos01(filaPedidos));
        executorSistema.execute(new ConsumidorDePedidos(filaPedidos,executorCalculo));
        //int consumidores = 3;
        //for (int i = 0; i < consumidores; i++) {
         //   executorSistema.execute(new ConsumidorDePedidos(filaPedidos, executorCalculo));
       // }
        //Deixe rodar por 30 segundos.
        Thread.sleep(10000);

        //Encerrar executors
        System.out.println("Encerrando sistema.");
        executorSistema.shutdownNow();
        executorCalculo.shutdownNow();

        executorSistema.awaitTermination(5, TimeUnit.SECONDS);
        executorCalculo.awaitTermination(5,TimeUnit.SECONDS);

        System.out.println("Sistema finalizado.");

    }
}
