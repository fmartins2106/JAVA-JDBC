package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.util.concurrent.*;

public class ConsumidorDePedidos10 implements Runnable{
    public final BlockingQueue<Pedido10> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos10(BlockingQueue<Pedido10> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos10 relatorioDePedidos10 = new RelatorioDePedidos10();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido10 pedido10 = filaPedido.take();
                System.out.println("Processando:"+pedido10);
                Future<BigDecimal> impostoFuturo = executor.submit(new CalcularImposto10(pedido10.getValor()));
                Future<BigDecimal> freteFuturo = executor.submit(new CalcularFrete10(pedido10.getValor()));

                BigDecimal imposto = impostoFuturo.get();
                BigDecimal frete = freteFuturo.get();

                BigDecimal total = pedido10.getValor().add(imposto).add(frete);

                System.out.printf("#ID:%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido10.getId(),pedido10.getCliente(),pedido10.getValor(),imposto,frete,total);

                relatorioDePedidos10.gerarRelatorio(pedido10,imposto,frete,total);

            }catch (InterruptedException e){
                System.out.println("Programa interrompido."+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Execução interrompida."+e.getMessage());
            }
        }
    }
}
