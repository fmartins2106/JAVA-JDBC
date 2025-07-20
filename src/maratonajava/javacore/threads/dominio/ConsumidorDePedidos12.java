package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos12 implements Runnable{
    public final BlockingQueue<Pedido12> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos12(BlockingQueue<Pedido12> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    @Override
    public void run() {
        RelatorioDePedidos12 relatorio = new RelatorioDePedidos12();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido12 pedido12 = filaPedido.take();
                System.out.println("Processando:"+pedido12);
                Future<BigDecimal> impostoFuturo = executor.submit(new CalcularImposto12(pedido12.getValor()));
                Future<BigDecimal> freteFuturo = executor.submit(new CalcularFrete12(pedido12.getValor()));

                BigDecimal imposto = impostoFuturo.get();
                BigDecimal frete = freteFuturo.get();

                BigDecimal total = pedido12.getValor().add(imposto).add(frete);

                System.out.printf("ID:#%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido12.getId(),pedido12.getCliente(),pedido12.getValor(),imposto,frete,total);

                relatorio.gerarRelatorio(pedido12,imposto,frete,total);
            }catch (InterruptedException e){
                System.out.println("Processo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Erro de execução:"+e.getMessage());
            }
        }
    }
}
