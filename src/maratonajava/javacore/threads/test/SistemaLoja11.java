package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos11;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido11;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos11;

import java.util.concurrent.*;

public class SistemaLoja11 {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido11> filaPedido = new LinkedBlockingQueue<>();
        int nThread = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThread);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThread);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos11(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos11(filaPedido,executorCalculo));

        Thread.sleep(20000);

        executorSistema.shutdownNow();

        while (!filaPedido.isEmpty()){
            Thread.sleep(500);
        }

        executorSistema.shutdownNow();
        if (!executorCalculo.awaitTermination(5, TimeUnit.SECONDS)){
            System.out.println("Forçando encerramento do cálculo...");
            executorCalculo.shutdownNow();
        }
        System.out.println("Sistema encerrado.");
        executorSistema.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println("Sistema finalizado.");



    }
}
