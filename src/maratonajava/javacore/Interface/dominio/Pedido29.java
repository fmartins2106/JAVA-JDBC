package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido29 {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void finalizarPedido(CarrinhoDeCompras29 carrinhoDeCompras29){
        if (carrinhoDeCompras29.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras29.calcularTotal();
        System.out.println("Pedido finalizado. Total:R$"+df.format(total));
    }
}
