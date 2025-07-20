package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos05 implements Runnable{
    public final BlockingQueue<Pedido05> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos05(BlockingQueue<Pedido05> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos05 relatorio = new RelatorioDePedidos05();
            while (!Thread.currentThread().isInterrupted()){
                try {
                Pedido05 pedido05 = filaPedido.take();
                System.out.println("Processando:"+pedido05);
                Future<Double> impostoFuturo = executor.submit(new CalcularImposto04(pedido05.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete05(pedido05.getValor()));

                double imposto = impostoFuturo.get();
                double frete = freteFuturo.get();

                double total = imposto + frete + pedido05.getValor();

                System.out.printf("#ID:%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido05.getId(),pedido05.getCliente(),pedido05.getValor(),imposto,frete,total);
                relatorio.gerarRelatorioPedidos(pedido05,imposto,frete,total);

            }catch (InterruptedException e){
                System.out.println("Erro no consumo do pedido."+e.getMessage());
            }catch (ExecutionException e){
                System.out.println("Erro de execução.");
            }
        }


    }

}
