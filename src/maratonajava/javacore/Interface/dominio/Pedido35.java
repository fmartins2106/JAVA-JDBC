package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido35 {

    public void finalizarPedido(CarrinhoDeCompras35 carrinhoDeCompras35){
        if (carrinhoDeCompras35.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras35.calcularTotal();
        System.out.println("Finalizando pedido. Total:R$"+CarrinhoDeCompras35.df.format(total));
    }
}
