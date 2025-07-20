package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido37 {

    public void finalizarPedido(CarrinhoDeCompras37 carrinhoDeCompras37){
        if (carrinhoDeCompras37.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras37.calcularTotal();
        System.out.println("Finalizando pedido, total da compra:R$"+CarrinhoDeCompras37.df.format(total));
    }
}
