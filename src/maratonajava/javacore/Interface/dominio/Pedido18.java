package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido18 {

    public void finalizarPedido(CarrinhoDeCompras18 carrinhoDeCompras18){
        if (carrinhoDeCompras18.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras18.calcularTotal();
        System.out.println("Pedido finalizado. Total:"+total);
    }
}
