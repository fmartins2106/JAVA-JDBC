package academy.devdojo.maratonajava.javacore.threads;

import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido04;
import academy.devdojo.maratonajava.javacore.threads.dominio.Pedido05;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos implements Runnable{
    public final BlockingQueue<Double> filaPedido;
    public final List<String> clientes = Arrays.asList("Ana","Maria","Joana","Fernando","Daisy","Marta","Manuel");
    public Random random = new Random();


    public ProdutorDePedidos(BlockingQueue<Double> filaPedido) {
        this.filaPedido = filaPedido;
    }

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorBruto = 50 + (random.nextInt(450));
                double valor = new BigDecimal(valorBruto).setScale(2,RoundingMode.HALF_UP)
                        .doubleValue();
                Pedido05 pedido05 = new Pedido05(cliente,valor);
                System.out.println("Novo Pedido adicionado");
                Thread.sleep(1000 + random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Produtor interrompido.");
                Thread.currentThread().interrupt();
            }catch (Exception e){
                System.out.println("Erro inesperado no produtor:"+e.getMessage());
            }
        }
    }
}
