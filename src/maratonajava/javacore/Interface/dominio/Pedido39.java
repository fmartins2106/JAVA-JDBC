package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido39 {

    public void finalizarPedido(CarrinhoDeCompras39 carrinhoDeCompras39){
        if (carrinhoDeCompras39.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = carrinhoDeCompras39.calcularTotal();
        System.out.println("Finalizando pedido:Total - R$"+CarrinhoDeCompras39.df.format(total));
    }

}
