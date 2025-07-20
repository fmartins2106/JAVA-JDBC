package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido38 {

    public void finalizarPedido(CarrinhoDeCompras38 carrinhoDeCompras38){
        if (carrinhoDeCompras38.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras38.calcularTotal();
        System.out.println("Pedido finalizado: total -> R$"+CarrinhoDeCompras38.df.format(total));
    }
}
