package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido06 {

    public void finalizarPedido(CarrinhoDeCompras06 carrinhoDeCompras06){
        if (carrinhoDeCompras06.estaVazio()){
            System.out.println("Carrinho vazio.");
        }else {
            double total = (carrinhoDeCompras06.calcularTotal());
            System.out.println("Pedido finalizado, total a pagar:R$"+total);
        }
    }
}
