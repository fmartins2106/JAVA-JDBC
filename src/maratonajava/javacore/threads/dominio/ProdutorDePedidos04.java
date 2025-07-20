package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos04 implements Runnable{
    public final BlockingQueue<Pedido04> filaPedido;
    public final List<String> clientes = Arrays.asList("Ana","Maria","Joana","Fernando","Daisy","Marta","Manuel");
    public final Random random = new Random();

    public ProdutorDePedidos04(BlockingQueue<Pedido04> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        try {
            while (!Thread.currentThread().isInterrupted()){
                String cliente = clientes.get(random.nextInt(clientes.size()));
                    double valor = 50 + (random.nextDouble() * 450);
                    Pedido04 pedido04 = new Pedido04(cliente,valor);
                    filaPedido.put(pedido04);
                System.out.println("Novo pedido adicionado:"+pedido04);
                Thread.sleep(1000 + random.nextInt(2000));
            }
        }catch (InterruptedException e){
            System.out.println("Produtor interrompido.");
            Thread.currentThread().interrupt();
        }
    }
}
