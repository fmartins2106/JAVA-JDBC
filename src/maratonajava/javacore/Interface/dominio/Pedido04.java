package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido04 {

    public void finalizarPedido(CarrinhoDeCompras04 carrinhoDeCompras04){
        if (carrinhoDeCompras04.estaVazio()){
            System.out.println("Carrinho vazio. Adicione um produto para prosseguir.");
            return;
        }
        double total = carrinhoDeCompras04.calcularTotal();
        System.out.println("Pedido finalizado, total a pagar:R$"+total);
    }
}
