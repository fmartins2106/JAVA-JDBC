package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido44 {

    public void finalizarPedido(CarrinhoDeCompras44 carrinhoDeCompras44){
        if (carrinhoDeCompras44.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras44.calcularTotal();
        System.out.println("Finalizando pedido. Total:R$"+CarrinhoDeCompras44.df.format(total));
    }
}
