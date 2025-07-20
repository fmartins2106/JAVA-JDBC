package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido12 {

    public void finalizarPedido(CarrinhoDeCompras12 carrinhoDeCompras12){
        if (carrinhoDeCompras12.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras12.totalCarrinho();
        System.out.println("Compra finalizada. Total ->R$"+total);
    }
}
