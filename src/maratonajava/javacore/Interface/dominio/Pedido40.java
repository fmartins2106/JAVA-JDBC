package academy.devdojo.maratonajava.javacore.Interface.dominio;

public class Pedido40 {
     public void finalizarPedido(CarrinhoDeCompras40 carrinhoDeCompras40){
         if (carrinhoDeCompras40.estaVazio()){
             System.out.println("Carrinho vazio.");
             return;
         }
         double total = carrinhoDeCompras40.calcularTotal();
         System.out.println("Finalizando pedido:R$"+CarrinhoDeCompras40.df.format(total));
     }
}
