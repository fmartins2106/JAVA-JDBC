package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido03 {

    public void finalizarPedido(CarrinhoDeCompras03 carrinhoDeCompras03){
        if (carrinhoDeCompras03.estaVazio()){
            System.out.println("Carrinho vazio. Adicionar um produto para prosseguir.");
            return;
        }
        double total = carrinhoDeCompras03.calcularTotal();
        System.out.println("Pedido finalizado, total a pagar: R$"+total);
    }
}
