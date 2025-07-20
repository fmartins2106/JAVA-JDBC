package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido28 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void finalizarPedido(CarrinhoDeCompras28 carrinhoDeCompras28){
        if (carrinhoDeCompras28.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras28.calcularTotal();
        System.out.println("Pedido finalizado:R$"+df.format(total));
    }
}
