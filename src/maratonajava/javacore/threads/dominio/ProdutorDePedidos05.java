package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos05 implements Runnable{
    public final BlockingQueue<Pedido05> filaPedido;
    public final List<String> clientes = Arrays.asList("Ana","Maria","Joana","Fernando","Daisy","Marta","Manuel");
    public Random random = new Random();

    public ProdutorDePedidos05(BlockingQueue<Pedido05> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
            while (!Thread.currentThread().isInterrupted()){
                try {
                    String cliente = clientes.get(random.nextInt(clientes.size()));
                    double valorBruto = 50 + (random.nextDouble() * 450);
                    double valor = new BigDecimal(valorBruto).setScale(2, RoundingMode.HALF_UP)
                            .doubleValue();
                    Pedido05 pedido05 = new Pedido05(cliente,valor);
                    filaPedido.put(pedido05);
                    System.out.println("Novo pedido adicionado:"+pedido05);
                    Thread.sleep(1000+ random.nextInt(2000));
                }catch (InterruptedException e){
                    System.out.println("Produtor interrompido.");
                    Thread.currentThread().interrupt();
                }
            }
    }



}
