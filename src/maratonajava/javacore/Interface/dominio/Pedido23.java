package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Pedido23 {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void finalizarPedido(CarrinhoDeCompras23 carrinhoDeCompras23){
        if (carrinhoDeCompras23.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras23.calcularTota();
        System.out.println("Pedido finalizado:R$"+df.format(total));
    }
}
