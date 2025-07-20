package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido15 {

    public void finalizarPedido(CarrinhoDeCompras15 carrinhoDeCompras15){
        if (carrinhoDeCompras15.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras15.calcularTotal();
        System.out.println("Pedido finalizado. Total da compra:R$"+total);
    }
}
