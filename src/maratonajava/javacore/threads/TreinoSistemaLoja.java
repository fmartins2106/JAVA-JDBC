package academy.devdojo.maratonajava.javacore.threads;

import academy.devdojo.maratonajava.javacore.threads.dominio.ConsumidorDePedidos06;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido06;
import academy.devdojo.maratonajava.javacore.threads.dominio.ProdutorDePedidos06;

import java.sql.Time;
import java.util.concurrent.*;

public class TreinoSistemaLoja {
    public static void main(String[] args) {
        // Cria uma fila bloqueante para troca de pedidos entre produtor e consumidor
        BlockingQueue<Pedido06> filaPedido = new LinkedBlockingQueue<>();

        // Obtém a quantidade de núcleos disponíveis no processador
        int nThreads = Runtime.getRuntime().availableProcessors();

        System.out.println("Núcleos disponíveis: " + nThreads); // Mostra quantos núcleos há

        // Executor para o sistema (produtor e consumidor), usando threads conforme os núcleos
        ExecutorService executorSistema = Executors.newFixedThreadPool(nThreads);

        // Executor para os cálculos (ex: imposto e frete), com 2 threads
        ExecutorService executorCalculo = Executors.newFixedThreadPool(2);

        // Inicia o produtor de pedidos, que adiciona pedidos na fila
        executorSistema.execute(new ProdutorDePedidos06(filaPedido));

        // Inicia o consumidor, que pega pedidos da fila e calcula imposto/frete usando o executorCalculo
        executorSistema.execute(new ConsumidorDePedidos06(filaPedido, executorCalculo));

        System.out.println("Encerrar sistema."); // Informa que vai iniciar o encerramento

        // Encerra imediatamente o executor do sistema (interrompe produtor e consumidor)
        executorSistema.shutdownNow();

        // Encerra imediatamente o executor dos cálculos
        executorCalculo.shutdownNow();

        try {
            // Aguarda até 5 segundos para os cálculos finalizarem
            executorCalculo.awaitTermination(5, TimeUnit.SECONDS);

            // Aguarda até 5 segundos para o sistema finalizar
            executorSistema.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // Se for interrompido enquanto espera, restaura o status da thread
            Thread.currentThread().interrupt();
        }

        System.out.println("Sistema finalizado."); // Confirma o fim do sistema
    }

}
