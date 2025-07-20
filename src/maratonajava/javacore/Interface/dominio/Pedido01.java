package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido01 {

    public void finalizarPedido(CarrinhoDeCompras01 carrinhoDeCompras01){
        if (carrinhoDeCompras01.estaVazio()){
            System.out.println("Carrinho vazio. Adicione um produto antes de prosseguir.");
            return;
        }
        double total = carrinhoDeCompras01.calcularTotal();
        System.out.println("Pedido finalizado, total a pagar:R$"+total);
    }
}
