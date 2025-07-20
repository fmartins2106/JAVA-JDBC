package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido42 {

    public void finalizarPedido(CarrinhoDeCompras42 carrinhoDeCompras42){
        if (carrinhoDeCompras42.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras42.calcularTotal();
        System.out.println("Pedido finalizado:R$"+CarrinhoDeCompras42.df.format(total));
    }
}
