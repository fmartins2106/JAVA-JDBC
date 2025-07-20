package academy.devdojo.maratonajava.javacore.threads.test;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos09;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido09;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos08;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos09;

import java.util.concurrent.*;

public class SistemaLoja09 {

    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Pedido09> filaPedido = new LinkedBlockingQueue<>();
        int nThread = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcles disponíveis:" + nThread);

        ExecutorService executorCalculo = Executors.newFixedThreadPool(nThread);
        ExecutorService executorSistema = Executors.newFixedThreadPool(2);

        // Inicia produtor e consumidor
        executorSistema.execute(new ProdutorDePedidos09(filaPedido));
        executorSistema.execute(new ConsumidorDePedidos09(filaPedido, executorCalculo));

        // Aguarda alguns segundos para simular tempo de execução normal
        Thread.sleep(20000);

        // Encerra o executor dos produtores e consumidores
        executorSistema.shutdownNow(); // Envia interrupção para as threads

        // Aguarda até a fila de pedidos esvaziar antes de encerrar o cálculo
        while (!filaPedido.isEmpty()) {
            Thread.sleep(500); // Espera processamento terminar
        }

        // Agora sim, encerra o executor de cálculo
        executorCalculo.shutdown();
        if (!executorCalculo.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forçando encerramento do cálculo...");
            executorCalculo.shutdownNow();
        }
        System.out.println("Sistema Encerrado.");
        executorSistema.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Sistema finalizado.");

    }
}
