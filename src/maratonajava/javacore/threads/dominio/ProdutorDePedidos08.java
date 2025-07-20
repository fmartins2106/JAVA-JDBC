package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos08 implements Runnable{
    public final BlockingQueue<Pedido08> filaPedido;
    public final List<String> clientes = Arrays.asList("Maria","Joana","Fernando","José");
    public Random random = new Random();

    public ProdutorDePedidos08(BlockingQueue<Pedido08> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorBruto = 50 + random.nextInt(450);
                double valor = new BigDecimal(valorBruto).setScale(2, RoundingMode.HALF_UP).doubleValue();

                Pedido08 pedido08 = new Pedido08(cliente,valor);

                filaPedido.put(pedido08);
                System.out.println("Pedido adicionado na fila:"+pedido08);

                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Processo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
