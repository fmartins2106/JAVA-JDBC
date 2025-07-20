package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido16 {

    public void finalizarPedido(CarrinhoDeCompras16 carrinhoDeCompras16){
        if (carrinhoDeCompras16.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras16.calcularTotal();
        System.out.println("Total da compra:R$"+total);
    }
}
