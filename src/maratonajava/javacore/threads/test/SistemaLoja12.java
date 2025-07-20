package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos12;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido12;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos12;

import java.util.concurrent.*;

public class SistemaLoja12 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Pedido12> filaPedio = new LinkedBlockingQueue<>();
        int nThread = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThread);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThread);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos12(filaPedio));
        executorSistema.execute(new ConsumidorDePedidos12(filaPedio,executorCalculo));

        Thread.sleep(20000);

        executorCalculo.shutdownNow();

        while (!filaPedio.isEmpty()){
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
