package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido10 {

    public void finalizarPedido(CarrinhoDeCompras10 carrinhoDeCompras10){
        if (carrinhoDeCompras10.estaVazio()){
            System.out.println("Carrinho vazio. Nenhum produto foi adicionado ao carrinho.");
            return;
        }
        double total = carrinhoDeCompras10.totalCarrinho();
        System.out.println("Total da compra:R$"+total);


    }
}
