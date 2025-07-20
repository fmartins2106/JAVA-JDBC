package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos09 implements Runnable{
    public final BlockingQueue<Pedido09> filaPedido;
    public final List<String> clientes = Arrays.asList("Marina","Joana","Pedro","Fernando");
    public final Random random = new Random();

    public ProdutorDePedidos09(BlockingQueue<Pedido09> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorBruto = 50 + random.nextInt(450);
                double valor = new BigDecimal(valorBruto).setScale(2, RoundingMode.HALF_UP).doubleValue();

                Pedido09 pedido09 = new Pedido09(cliente,valor);
                filaPedido.put(pedido09);
                System.out.println("Produto adicionado na fila:"+pedido09);
                Thread.sleep(1000 + random.nextInt(2000));

            }catch (InterruptedException e){
                System.out.println("Processo Interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

}
