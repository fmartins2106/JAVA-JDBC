package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido26 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void finalizarPedido(CarrinhoDeCompras26 carrinhoDeCompras26){
        if (carrinhoDeCompras26.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras26.calcularTotal();
        System.out.println("Pedido finalizado:R$"+df.format(total));
    }
}
