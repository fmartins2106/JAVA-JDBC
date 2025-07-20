package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos07 implements Runnable{
    public final BlockingQueue<Pedido07> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos07(BlockingQueue<Pedido07> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos07 relatorio = new RelatorioDePedidos07();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido07 pedido07 = filaPedido.take();
                System.out.println("Processando:"+pedido07);

                Future<Double> impostoFuturo = executor.submit(new CalcularImposto07(pedido07.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete07(pedido07.getValor()));

                double imposto = impostoFuturo.get();
                double frete = freteFuturo.get();

                double total = pedido07.getValor() + imposto + frete;

                System.out.printf("ID:#%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido07.getId(),pedido07.getCliente(),pedido07.getValor(),imposto,frete,total);
                relatorio.gerarRelatorio(pedido07,imposto,frete,total);
            }catch (InterruptedException e){
                System.out.println("Consumo de pedidos interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Erro na execução:"+e.getMessage());
            }
        }
    }

}
