package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido14 {

    public void finalziarPedido(CarrinhoDeCompras14 carrinhoDeCompras14){
        if (carrinhoDeCompras14.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras14.calculartTotal();
        System.out.println("Pedido finalizado. Total da compra:R$"+total);
    }
}
