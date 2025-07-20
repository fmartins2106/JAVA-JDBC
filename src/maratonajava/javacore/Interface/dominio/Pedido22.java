package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido22 {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void finalizarPedido(CarrinhoDeCompras22 carrinhoDeCompras22){
        if (carrinhoDeCompras22.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras22.totalCompras();
        System.out.println("Finalizando pedido:R$"+df.format(total));
    }
}
