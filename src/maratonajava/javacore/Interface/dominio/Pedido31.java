package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido31 {

    public void finalizarPedido(CarrinhoDeCompras31 carrinhoDeCompras31){
        if (carrinhoDeCompras31.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras31.calcularTotal();
        System.out.println("Finalizando pedido:R$"+CarrinhoDeCompras31.df.format(total));
    }
}
