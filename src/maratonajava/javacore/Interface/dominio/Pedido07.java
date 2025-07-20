package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido07 {

    public void finalizarPedido(CarrinhoDeCompras07 carrinhoDeCompras07){
        if (carrinhoDeCompras07.estaVazio()){
            System.out.println("Carrinho vazio.");
        }else {
            double total = carrinhoDeCompras07.calcularTotal();
            System.out.println("Pedido finalizado, total a pagar:R$"+total);
        }
    }
}
