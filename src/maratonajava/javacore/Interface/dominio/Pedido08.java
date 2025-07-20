package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido08 {

    public void finalizarPedido(CarrinhoDeCompras08 carrinhoDeCompras08){
        if (carrinhoDeCompras08.estaVazio()){
            System.out.println("Nenhum produto foi adicionado no carrinho.");
        }else {
            double total = carrinhoDeCompras08.calcularTotal();
            System.out.println("Pedido finalizado. Total a pagar:R$"+total);
        }
    }
}
