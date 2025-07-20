package academy.devdojo.maratonajava.javacore.threads;

import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido06;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

public class TreinoProdutorDePedidos03 implements Runnable {
    public final BlockingQueue<Pedido06> filaPedidos;
    public final List<String> clientes = Arrays.asList("Maria","Fernando","Marta","Ana","José");
    public Random random = new Random();

    public TreinoProdutorDePedidos03(BlockingQueue<Pedido06> filaPedidos, ExecutorService executor) {
        this.filaPedidos = filaPedidos;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorBruto = 50 + random.nextInt(450);
                double valor = new BigDecimal(valorBruto).setScale(2, RoundingMode.HALF_UP).doubleValue();
                Pedido06 pedido06 = new Pedido06(cliente,valor);
                filaPedidos.put(pedido06);
                System.out.println("Novo pedido adicionado.");
                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Processo interrompido:"+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
