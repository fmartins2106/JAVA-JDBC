package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido33 {

    public void finalizarPedido(CarrinhoDeCompras33 carrinhoDeCompras33){
        if (carrinhoDeCompras33.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras33.calcularTotal();
        System.out.println("Finalizando pedido:R$"+CarrinhoDeCompras33.df.format(total));
    }
}
