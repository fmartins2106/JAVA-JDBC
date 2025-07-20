package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConsumidorDePedidos08 implements Runnable{
    public final BlockingQueue<Pedido08> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos08(BlockingQueue<Pedido08> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos08 relatorio = new RelatorioDePedidos08();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido08 pedido08 = filaPedido.take();
                System.out.println("Processando:"+pedido08);

                Future<Double> impostoFuturo = executor.submit(new CalcularImposto08(pedido08.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete08(pedido08.getValor()));

                double imposto = impostoFuturo.get();
                double frete = freteFuturo.get();

                double total = pedido08.getValor() + imposto + frete;

                System.out.printf("#ID:%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido08.getId(),pedido08.getCliente(),pedido08.getValor(),imposto,frete,total);

                relatorio.gerarRelatorio(pedido08,imposto,frete,total);
            }catch (InterruptedException e){
                System.out.println("Erro de interrupção:"+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Erro de execução:"+e.getMessage());
            }
        }
    }

}
