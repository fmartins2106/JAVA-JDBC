package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.*;

public class ConsumidorDePedidos06 implements Runnable {
    public final BlockingQueue<Pedido06> filaPedido;
    public final ExecutorService executor;

    public ConsumidorDePedidos06(BlockingQueue<Pedido06> filaPedido, ExecutorService executor) {
        this.filaPedido = filaPedido;
        this.executor = executor;
    }

    public void run(){
        RelatorioDePedidos06 relatorio = new RelatorioDePedidos06();
        while (!Thread.currentThread().isInterrupted()){
            try {
                Pedido06 pedido06 = filaPedido.take();
                System.out.println("Processando:"+pedido06);
                Future<Double> impostoFuturo = executor.submit(new CalcularImposto06(pedido06.getValor()));
                Future<Double> freteFuturo = executor.submit(new CalcularFrete06(pedido06.getValor()));

                double imposto = impostoFuturo.get();
                double frete = freteFuturo.get();

                double total = pedido06.getValor() + imposto + frete;

                System.out.printf("ID:[%d] |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n\n",
                        pedido06.getId(),pedido06.getCliente(),pedido06.getValor(),imposto,frete,total);

                relatorio.gerarRelatorioPedidos(pedido06,imposto,frete,total);

            }catch (InterruptedException e){
                System.out.println("Erro no consumo do pedido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }catch (ExecutionException e){
                System.out.println("Erro de execussão:"+e.getMessage());
            }
        }
    }

}
