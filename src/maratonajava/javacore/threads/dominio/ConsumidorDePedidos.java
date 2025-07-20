package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos implements Runnable{
    private final BlockingQueue<Pedido01> filaPedidos;
    private final ExecutorService executor;

    public ConsumidorDePedidos(BlockingQueue<Pedido01> filaPedidos, ExecutorService executor) {
        this.filaPedidos = filaPedidos;
        this.executor = executor;
    }

    @Override
    public void run() {
        RelatorioDePedido01 relatorio = new RelatorioDePedido01(); // instância da classe de relatório
        try {
            while (!Thread.currentThread().isInterrupted()){
                Pedido01 pedido01 = filaPedidos.take(); //Bloqueia até o pedido;
                System.out.println("Processando: "+pedido01);
                //executa cáculo de imposto e frete em paralelo
                Future<Double> impostoFuturo = executor.submit(new CalcularImposto01(pedido01.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete01(pedido01.getValor()));

                double imposto = impostoFuturo.get(); //Espera retorno.
                double frete = freteFuturo.get();

                double total = pedido01.getValor() + imposto + frete;

                System.out.printf("Pedido #%d finalizado. Imposto:R$%.2f | Frete:R$%.2f | Total:R$%.2f\n\n",
                        pedido01.getId(),imposto,frete,total);
                relatorio.salvarRelatorio(pedido01, imposto, frete, total);
            }
        }catch (InterruptedException e){
            System.out.println("Consumidor interrompido.");
            Thread.currentThread().interrupt();
        }catch (ExecutionException e){
            System.out.println("Erro no cálculo:"+e.getMessage());
        }
    }
}
/**
 * Classe responsável por consumir e processar pedidos de forma assíncrona.
 * Implementa a interface Runnable, o que permite que ela seja executada em uma thread separada.
 *
 * Normalmente, essa classe é usada em conjunto com uma fila de pedidos (como BlockingQueue),
 * onde ela ficará esperando por novos pedidos e os processará assim que chegarem.
 *
 * Ideal para simular o comportamento de consumidores em sistemas baseados em filas ou mensageria,
 * como em cenários de processamento paralelo, microservices ou sistemas reativos.
 */