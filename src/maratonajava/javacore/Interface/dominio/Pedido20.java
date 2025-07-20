package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido20 {

    public void finalizarPedido(CarrinhoDeCompras20 carrinhoDeCompras20){
        if (carrinhoDeCompras20.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras20.calculandoTotal();
        System.out.println("Pedido finalizado:R$"+total);
    }
}
