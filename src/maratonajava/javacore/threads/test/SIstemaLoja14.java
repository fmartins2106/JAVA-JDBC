package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos14;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido14;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos14;

import java.util.concurrent.*;

public class SIstemaLoja14 {

    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido14> filaPedido = new LinkedBlockingQueue<>();
        int nThread = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleo disponíveis:"+nThread);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThread);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos14(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos14(filaPedido,executorCalculo));

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
