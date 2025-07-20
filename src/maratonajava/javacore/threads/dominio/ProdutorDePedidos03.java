package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos03 implements Runnable{
    private final BlockingQueue<Pedido03> filaPedido;
    private final List<String> clientes = Arrays.asList("Ana","Maria","Joana","Fernando","Daisy","Marta","Manuel");
    private final Random random = new Random();

    public ProdutorDePedidos03(BlockingQueue<Pedido03> filaPedido) {
        this.filaPedido = filaPedido;
    }

    @Override
    public void run(){
        try {
            while (!Thread.currentThread().isInterrupted()){
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valor = 50 + (random.nextDouble() * 450);
                Pedido03 pedido03 = new Pedido03(cliente,valor);
                filaPedido.put(pedido03);
                System.out.println("Novo pedido adicionado:"+pedido03);
                Thread.sleep(1000 + random.nextInt(2000));
            }
        }catch (InterruptedException e){
            System.out.println("Produtor interrompido");
            Thread.currentThread().interrupt();
        }
    }
}
