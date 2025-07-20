package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido17 {

    public void finalizarPedido(CarrinhoDeCompras17 carrinhoDeCompras17){
        if (carrinhoDeCompras17.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras17.totalCarrinho();
        System.out.println("Total da compra:R$"+total);
    }
}
