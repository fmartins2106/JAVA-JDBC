package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido05 {

    public void finalizarPedido(CarrinhoDeCompras05 carrinhoDeCompras05){
        if (carrinhoDeCompras05.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras05.calcularTotal();
        System.out.println("Pedido finalizado, total a pagar R$"+total);
    }
}
