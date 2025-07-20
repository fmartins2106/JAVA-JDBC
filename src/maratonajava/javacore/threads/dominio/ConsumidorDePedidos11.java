package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos11 implements Runnable{
    public final BlockingQueue<Pedido11> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos11(BlockingQueue<Pedido11> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos11 relatorioDePedidos11 = new RelatorioDePedidos11();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido11 pedido11 = filaPedido.take();
                System.out.println("Processando:"+pedido11);
                Future<BigDecimal> impostoFuturo = executor.submit(new CalcularImposto11(pedido11.getValor()));
                Future<BigDecimal> freteFuturo = executor.submit(new CalcularFrete11(pedido11.getValor()));

                BigDecimal imposto = impostoFuturo.get();
                BigDecimal frete = freteFuturo.get();

                BigDecimal total = pedido11.getValor().add(imposto).add(frete);

                System.out.printf("#ID:%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido11.getId(),pedido11.getCliente(),pedido11.getValor(),imposto,frete,total);

                relatorioDePedidos11.gerarRelatorio(pedido11,imposto,frete,imposto);

            }catch (InterruptedException e){
                System.out.println("Processo interrompido."+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Processo não executado:"+e.getMessage());
            }
        }
    }

}
