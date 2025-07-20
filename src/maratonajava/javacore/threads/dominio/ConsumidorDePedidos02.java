package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos02 implements Runnable {
    private final BlockingQueue<Pedido02> filaPedidos;
    private final ExecutorService executor;

    public ConsumidorDePedidos02(BlockingQueue<Pedido02> filaPedidos, ExecutorService executor) {
        this.filaPedidos = filaPedidos;
        this.executor = executor;
    }


    public void run(){
        RelatorioDePedido02 relatorio = new RelatorioDePedido02();
        try {
            while (!Thread.currentThread().isInterrupted()){
                Pedido02 pedido02 = filaPedidos.take();
                System.out.println("Processando:"+pedido02);
                Future<Double> impostoFuturo = executor.submit(new CalcularImposto02(pedido02.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete02(pedido02.getValor()));

                double imposto = impostoFuturo.get();
                double frete = freteFuturo.get();

                double total = pedido02.getValor() + imposto + frete;
                System.out.printf("Pedido: #%d finalizado. Imposto:R$%.2f | Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido02.getId(),imposto,frete,total);
                relatorio.gravarRelatorio(pedido02,imposto,frete,total);
            }
        }catch (InterruptedException e){
            System.out.println("Coonsumidor Interrompido.");
            Thread.currentThread().interrupt();
        }catch (ExecutionException e){
            System.out.println("Erro no cáculo:"+e.getMessage());
        }
    }

}
