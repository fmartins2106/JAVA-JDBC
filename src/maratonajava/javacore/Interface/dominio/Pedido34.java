package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido34 {

    public void finalizarPedido(CarrinhoDeCompras34 carrinhoDeCompras34){
        if (carrinhoDeCompras34.estaVazio()){
            System.out.println("Nenhum produto foi adicionado.");
            return;
        }
        double total = carrinhoDeCompras34.calcularTotal();
        System.out.println("Finalizando pedido:R$"+CarrinhoDeCompras34.df.format(total));
    }
}
