package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos12 implements Runnable{
    public final BlockingQueue<Pedido12> filaPedido;
    public final List<String> clientes = Arrays.asList("Maria","Marta","Fernando","Joana","José");
    public final Random random = new Random();

    public ProdutorDePedidos12(BlockingQueue<Pedido12> filaPedido) {
        this.filaPedido = filaPedido;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorDoPedido = 50 + random.nextDouble(450);
                BigDecimal valor = BigDecimal.valueOf(valorDoPedido).setScale(2,RoundingMode.HALF_UP);
                Pedido12 pedido12 = new Pedido12(cliente,valor);

                filaPedido.put(pedido12);

                System.out.println("Adicionando pedido na fila:"+pedido12);

                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Processo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
