package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido02 {

    public void finalizarPedido(CarrinhoDeCompras02 carrinhoDeCompras02){
        if (carrinhoDeCompras02.estaVaizio()){
            System.out.println("Carrinho vazio. Adicione um produto para prosseguir.");
            return;
        }
        double total = carrinhoDeCompras02.calcularTotal();
        System.out.println("Pedido finalizado, total a pagar:R$"+total);
    }
}
