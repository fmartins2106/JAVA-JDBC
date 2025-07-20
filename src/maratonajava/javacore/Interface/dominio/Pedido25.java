package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido25 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void finalizarPedido(CarrinhoDeCompras25 carrinhoDeCompras25){
        if (carrinhoDeCompras25.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras25.calcularTotal();
        System.out.println("Pedido finalizado:R$"+df.format(total));

    }
}
