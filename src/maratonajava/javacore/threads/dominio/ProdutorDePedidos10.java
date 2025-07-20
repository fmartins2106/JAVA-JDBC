package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos10 implements Runnable{
    public final BlockingQueue<Pedido10> filaPedido;
    public final List<String> clientes = Arrays.asList("Maria","Joana","Marta","Fernando","José");
    public Random random = new Random();

    public ProdutorDePedidos10(BlockingQueue<Pedido10> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorInt = 50 + random.nextDouble(450);
                BigDecimal valor = BigDecimal.valueOf(valorInt);
                Pedido10 pedido10 = new Pedido10(cliente,valor);
                filaPedido.put(pedido10);
                System.out.println("Pedido adicionando na fila:"+pedido10);
                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Programa interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

}
