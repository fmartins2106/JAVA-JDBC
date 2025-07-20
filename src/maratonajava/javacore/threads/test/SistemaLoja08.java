package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos08;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido08;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos07;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos08;

import java.util.concurrent.*;

public class SistemaLoja08 {

    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido08> filaPedido = new LinkedBlockingQueue<>();
        int nThread = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos disponíveis:"+nThread);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThread);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        executorSistema.execute(new ProdutorDePedidos08(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos08(filaPedido,executorCalculo));

        Thread.sleep(20000);
        
        executorCalculo.shutdownNow();
        executorSistema.shutdownNow();

        System.out.println("Sistema encerrado.");


        executorCalculo.awaitTermination(5, TimeUnit.SECONDS);
        executorSistema.awaitTermination(5,TimeUnit.SECONDS);

        System.out.println("Sistema finalizando.");
    }
}
