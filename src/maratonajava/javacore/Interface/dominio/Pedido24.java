package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido24 {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void finalizarPedido(CarrinhoDeCompras24 carrinhoDeCompras24){
        if (carrinhoDeCompras24.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras24.totalCompras();
        System.out.println("Pedido finalizado:R$"+df.format(total));
    }
}
