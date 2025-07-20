package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido19 {
    public static final DecimalFormat df = new DecimalFormat("0.00");
    public void finalizarPedido(CarrinhoDeCompras19 carrinhoDeCompras19){
        if (carrinhoDeCompras19.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras19.calcularTotal();
        System.out.println("Pedido finalizado:R$"+df.format(total));
    }
}
