package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras31 {
    List<Vendavel31> produtosCarrinho = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto31 produto31, int quantidade){
        if (produto31.retirarCarrinho(quantidade)){
            produtosCarrinho.add(produto31);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarCarrinho(int index){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        if (index >= 0 && index < produtosCarrinho.size()){
            Produto31 produto31 = (Produto31) produtosCarrinho.get(index);
            produto31.devolverEstoque(quantidades.get(index));
            produtosCarrinho.remove(index);
            quantidades.remove(index);
            System.out.println("Produto removido do carrinho.");
            return;
        }
        System.out.println("Indice não encontrado.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel31 produto = produtosCarrinho.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((1+i)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            total += produtosCarrinho.get(i).getPreco() * quantidades.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtosCarrinho.isEmpty();
    }
}
