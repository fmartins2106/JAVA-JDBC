package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido13 {

    public void finalizarPedido(CarrinhoDeCompras13 carrinhoDeCompras13){
        if (carrinhoDeCompras13.estaVazio()){
            System.out.println("Nenhum produto foi adicionado no carrinho.");
            return;
        }
        double total = carrinhoDeCompras13.calcularTotal();
        System.out.println("Finalizando pedido. Total:R$"+total);
    }
}
