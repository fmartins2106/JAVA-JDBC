package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos13 implements Runnable{
    public final BlockingQueue<Pedido13> filaPedido;
    public final List<String> clientes = Arrays.asList("Maria","Joana","Marta","Fernando","José");
    public final Random random = new Random();

    public ProdutorDePedidos13(BlockingQueue<Pedido13> filaPedido) {
        this.filaPedido = filaPedido;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valor = 50 + random.nextDouble(450);
                BigDecimal valorFinal = BigDecimal.valueOf(valor).setScale(2,RoundingMode.HALF_UP);;
                Pedido13 pedido13 = new Pedido13(cliente,valorFinal);

                filaPedido.put(pedido13);

                System.out.println("Pedido adicionado na fila:"+pedido13);

                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Processo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
