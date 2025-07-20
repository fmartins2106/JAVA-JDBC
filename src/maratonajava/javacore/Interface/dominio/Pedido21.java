package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido21 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void finalizarPedido(CarrinhoDeCompras21 carrinhoDeCompras21){
        if (carrinhoDeCompras21.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras21.calcularTotal();
        System.out.println("Pedido finalizado, Total:R$"+df.format(total));
    }
}
