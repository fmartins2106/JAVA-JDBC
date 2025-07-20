package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos14 implements Runnable{
    public final BlockingQueue<Pedido14> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos14(BlockingQueue<Pedido14> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos14 relatorio = new RelatorioDePedidos14();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido14 pedido14 = filaPedido.take();
                System.out.println("Processando pedido:"+pedido14);
                Future<BigDecimal> impostoFuturo = executor.submit(new CalcularImposto14(pedido14.getValor()));
                Future<BigDecimal> freteFuturo = executor.submit(new CalcularFrete14(pedido14.getValor()));

                BigDecimal imposto = impostoFuturo.get();
                BigDecimal frete = freteFuturo.get();

                BigDecimal total = pedido14.getValor().add(imposto).add(frete);

                System.out.printf("ID:#%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido14.getId(),pedido14.getCliente(),pedido14.getValor(),imposto,frete,total);

                relatorio.gerarRelatorio(pedido14,imposto,frete,total);
            }catch (InterruptedException e){
                System.out.println("Processo de consumo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Erro na execução:"+e.getMessage());
            }
        }
    }

}
