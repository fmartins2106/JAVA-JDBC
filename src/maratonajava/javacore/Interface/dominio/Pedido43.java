package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido43 {
    public void finalizarPedido(CarrinhoDeCompras43 carrinhoDeCompras43){
        if (carrinhoDeCompras43.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras43.calcularTotal();
        System.out.println("Finalizando pedido:R$"+CarrinhoDeCompras43.df.format(total));
    }
}
