package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido27 {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void finalizarPedido(CarrinhoDeCompras27 carrinhoDeCompras27){
        if (carrinhoDeCompras27.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras27.calcularTotal();
        System.out.println("Pedido finalizado:"+df.format(total));
    }
}
