package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido41 {
    public void finalizarPedido(CarrinhoDeCompras41 carrinhoDeCompras41){
        if (carrinhoDeCompras41.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras41.calcularTotal();
        System.out.println("Pedido finalizado:R$"+CarrinhoDeCompras41.df.format(total));
    }
}
