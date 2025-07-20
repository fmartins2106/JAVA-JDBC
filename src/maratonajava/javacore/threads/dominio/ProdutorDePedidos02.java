package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos02 implements Runnable{
    private final BlockingQueue<Pedido02> filaPedidos;
    private final List<String> clientes = Arrays.asList("Ana","Maria","Joana","Fernando","Daisy","Marta","Manuel");
    private final Random random = new Random();

    public ProdutorDePedidos02(BlockingQueue<Pedido02> filaPedidos) {
        this.filaPedidos = filaPedidos;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valor = 50 + (random.nextDouble() * 450);
                Pedido02 pedido02 = new Pedido02(cliente,valor);
                filaPedidos.put(pedido02);
                System.out.println("Novo pedido adicionado:"+pedido02);
                Thread.sleep(1000+ random.nextInt(2000));
            }
        }catch (InterruptedException e){
            System.out.println("Prdutor Interrompido.");
            Thread.currentThread().interrupt();
        }
    }
}
