package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos06 implements Runnable{
    public final BlockingQueue<Pedido06> filaPedido;
    public final List<String> clientes = Arrays.asList("Maria","Pedro","João","Mariana","Fernando","Daisy");
    public Random random = new Random();

    public ProdutorDePedidos06(BlockingQueue<Pedido06> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorBruto = 50 + random.nextInt(450);
                double valor = new BigDecimal(valorBruto).setScale(2, RoundingMode.HALF_UP)
                        .doubleValue();
                Pedido06 pedido06 = new Pedido06(cliente,valor);
                filaPedido.put(pedido06);
                System.out.println("Novo pedido adicionado:"+pedido06);
                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Erro na geração do pedido:");
                Thread.currentThread().interrupt();
            }
        }
    }
}
