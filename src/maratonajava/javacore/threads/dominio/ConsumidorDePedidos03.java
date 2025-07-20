package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos03 implements Runnable {
    private final BlockingQueue<Pedido03> filaPedido;
    private final ExecutorService executor;

    public ConsumidorDePedidos03(BlockingQueue<Pedido03> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos03 relatorio = new RelatorioDePedidos03();
        try {
            while (!Thread.currentThread().isInterrupted()){
                Pedido03 pedido03 = filaPedido.take();
                System.out.println("Processando:"+pedido03);
                Future<Double> impostoFuturo = executor.submit(new CalcularImposto03(pedido03.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete03(pedido03.getValor()));

                double imposto = impostoFuturo.get();
                double frete = freteFuturo.get();

                double total = pedido03.getValor() + imposto + frete;
                System.out.printf("Pedido:#ID:%d finalizado. Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido03.getId(),imposto,frete,total);
                relatorio.gerarRelatorio(pedido03,imposto,frete,total);

            }
        }catch (InterruptedException e){
            System.out.println("Consumidor interrompido.");
            Thread.currentThread().interrupt();
        }catch (ExecutionException e){
            System.out.printf("Erro de cálculo"+e.getMessage());
        }
    }

}
