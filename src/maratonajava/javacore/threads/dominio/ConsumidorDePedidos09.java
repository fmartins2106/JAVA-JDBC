package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos09 implements Runnable{
    public final BlockingQueue<Pedido09> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos09(BlockingQueue<Pedido09> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos09 relatorio = new RelatorioDePedidos09();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido09 pedido09 = filaPedido.take();
                System.out.println("Processando:"+pedido09);
                Future<Double> impostoFuturo = executor.submit(new CalcularImposto09(pedido09.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete09(pedido09.getValor()));

                double imposto = impostoFuturo.get();
                double frete = freteFuturo.get();

                double total = pedido09.getValor() + imposto + frete;

                System.out.printf("#ID:%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido09.getId(),pedido09.getCliente(),pedido09.getValor(),imposto,frete,total);
                ;

                relatorio.gerarRelatorio(pedido09,imposto,frete,total);

            }catch (InterruptedException e){
                System.out.println("Consumo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Erro na execussão:"+e.getMessage());
            }
        }
    }

}
