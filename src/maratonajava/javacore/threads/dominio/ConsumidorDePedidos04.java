package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos04 implements Runnable{
    public final BlockingQueue<Pedido04> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos04(BlockingQueue<Pedido04> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos04 relatorio = new RelatorioDePedidos04();
        try {
            while (!Thread.currentThread().isInterrupted()){
                Pedido04 pedido04 = filaPedido.take();
                System.out.println("Processando:"+pedido04);
                Future<Double> impostoFuturo = executor.submit(new CalcularImposto04(pedido04.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete04(pedido04.getValor()));

                double imposto = impostoFuturo.get();
                double frete = freteFuturo.get();

                double total = imposto + frete + pedido04.getValor();

                System.out.printf("Pedido #ID:%d finalizado. |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido04.getId(),pedido04.getCliente(),pedido04.getValor(),imposto,frete,total);
                relatorio.gerarRelatorio(pedido04,imposto,frete,total);
            }
        }catch (InterruptedException e){
            System.out.println("Erro no consumo do pedido.");
            Thread.currentThread().interrupt();
        }catch (ExecutionException e){
            System.out.println("Erro ");
        }
    }

}
