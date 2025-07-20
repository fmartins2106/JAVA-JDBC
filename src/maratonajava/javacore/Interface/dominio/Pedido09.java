package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido09 {
    public void finalizarPedido(CarrinhoDeCompras09 carrinhoDeCompras09){
        if (carrinhoDeCompras09.estaVazio()){
            System.out.println("Carrinho vazio.");
        }else {
            double total = carrinhoDeCompras09.totalCarrinho();
            System.out.println("Pedido finalizado:R$"+total);
        }
    }
}
