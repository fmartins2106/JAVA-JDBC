package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido36 {

    public void finalizarPedido(CarrinhoDeCompras36 carrinhoDeCompras36){
        if (carrinhoDeCompras36.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras36.calcularTotal();
        System.out.println("Finalizando pedido:"+CarrinhoDeCompras36.df.format(total));
    }
}
