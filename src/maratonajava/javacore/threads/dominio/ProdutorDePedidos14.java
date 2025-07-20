package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos14 implements Runnable{
    public final BlockingQueue<Pedido14> filaPedido;
    public final List<String> clientes = Arrays.asList("Maria","Joana","Marta","Fernando","José");
    public final Random random = new Random();

    public ProdutorDePedidos14(BlockingQueue<Pedido14> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorPedido = 50 + random.nextInt(450);
                BigDecimal valor = new BigDecimal(valorPedido).setScale(2, RoundingMode.HALF_UP);
                Pedido14 pedido14 = new Pedido14(cliente,valor);
                System.out.println("Pedido adicionado na fila:"+pedido14);
                filaPedido.put(pedido14);
                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Processo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
