package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ProdutorDePedidos07 implements Runnable{
    public final BlockingQueue<Pedido07> filaPedido;
    public final List<String> clientes = Arrays.asList("José","Maria","Pedro","Maria","Joana","Marta");
    public final Random random = new Random();

    public ProdutorDePedidos07(BlockingQueue<Pedido07> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorBruto = 50 + random.nextInt(450);
                double valor = new BigDecimal(valorBruto).setScale(2, RoundingMode.HALF_UP).doubleValue();
                Pedido07 pedido07 = new Pedido07(cliente,valor);
                filaPedido.put(pedido07);
                System.out.println("Pedido adicionado na fila:"+pedido07);
                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Erro na execução do pedido."+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
