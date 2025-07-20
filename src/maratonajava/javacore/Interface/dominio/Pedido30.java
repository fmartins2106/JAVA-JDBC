package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido30 {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void finalizarPedido(CarrinhoDeCompras30 carrinhoDeCompras30){
        if (carrinhoDeCompras30.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras30.calcularTotal();
        System.out.println("Finalizando pedido. TOTAL:R$"+df.format(total));
    }

}
