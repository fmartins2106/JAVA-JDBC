package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido45 {

    public void finalizarPedido(CarrinhoDeCompras45 carrinhoDeCompras45){
        if (carrinhoDeCompras45.estaVazio()){
            System.out.println("Carrino vazio.");
            return;
        }
        double total = carrinhoDeCompras45.calcularTotal();
        System.out.println("Finalizando a compra. Total:R$"+CarrinhoDeCompras45.df.format(total));
    }
}
