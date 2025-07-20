package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos01 implements Runnable{
    private final BlockingQueue<Pedido01> filaPedidos;
    private final List<String> clientes = Arrays.asList("Ana","Fernando","Maria","Joana","Marta");
    private final Random random = new Random();

    public ProdutorDePedidos01(BlockingQueue<Pedido01> filaPedidos) {
        this.filaPedidos = filaPedidos;
    }

    @Override
    public void run(){
        try {
            while (!Thread.currentThread().isInterrupted()){
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valor = 50 + (random.nextDouble() * 450); //valor entre 50 e 500
                Pedido01 pedido01 = new Pedido01(cliente,valor);
                filaPedidos.put(pedido01); // bloqueia a fila cheia.
                System.out.println("Novo pedido adicionado:"+pedido01);
                Thread.sleep(1000 + random.nextInt(2000)); // entre 1s e 3s entre pedidos;
            }
        }catch (InterruptedException e){
            System.out.println("Produtor Interrompido.");
            Thread.currentThread().interrupt();
        }
    }

}
