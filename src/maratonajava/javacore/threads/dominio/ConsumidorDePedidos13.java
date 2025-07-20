package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos13 implements Runnable{
    public final BlockingQueue<Pedido13> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos13(BlockingQueue<Pedido13> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    @Override
    public void run() {
        RelatorioDePedidos13 relatorioDePedidos13 = new RelatorioDePedidos13();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido13 pedido13 = filaPedido.take();
                System.out.println("Processando:"+pedido13);
                Future<BigDecimal> impostoFuturo = executor.submit(new CalcularImposto13(pedido13.getValor()));
                Future<BigDecimal> freteFuturo = executor.submit(new CalcularFrete13(pedido13.getValor()));

                BigDecimal imposto = impostoFuturo.get();
                BigDecimal frete = freteFuturo.get();

                BigDecimal total = pedido13.getValor().add(imposto).add(frete);

                System.out.printf("ID:#%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido13.getId(),pedido13.getCliente(),pedido13.getValor(),imposto,frete,total);

                relatorioDePedidos13.gerarRelatorio(pedido13,imposto,frete,total);
            }catch (InterruptedException e){
                System.out.println("Processo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Erro de execução."+e.getMessage());
            }
        }
    }
}
