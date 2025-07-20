package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos11 implements Runnable{
    public final BlockingQueue<Pedido11> filaPedido;
    public final List<String> clientes = Arrays.asList("Maria","Juliana","Marta","Fernando","José");
    public final Random random = new Random();

    public ProdutorDePedidos11(BlockingQueue<Pedido11> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorPedido = 50 + random.nextDouble(450);
                BigDecimal valor = BigDecimal.valueOf(valorPedido);
                Pedido11 pedido11 = new Pedido11(cliente,valor);
                filaPedido.put(pedido11);
                System.out.println("Pedido adicionado na fila:"+pedido11);
                Thread.sleep(1500 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Processo produtor interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
