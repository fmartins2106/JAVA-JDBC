package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido32 {

    public void finalizarPedido(CarrinhoDeCompras32 carrinhoDeCompras32){
        if (carrinhoDeCompras32.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras32.calcularTotal();
        System.out.println("Finalizando pedido:R$"+CarrinhoDeCompras32.df.format(total));
    }
}
