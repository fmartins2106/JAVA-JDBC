package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido11 {

    public void finalizarPedido(CarrinhoDeCompras11 carrinhoDeCompras11){
        if (carrinhoDeCompras11.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras11.calcularTotal();
        System.out.println("______________________________________");
        System.out.println("Pedido finalizado. >>> Total:R$"+total);
        System.out.println("______________________________________");
    }
}
