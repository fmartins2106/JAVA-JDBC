package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras41 {
    List<Vendavel41>  produtosCarrinho = new ArrayList<>();
    List<Integer> quantidadeCarrinho = new ArrayList<>();

    public void addCarrinho(Produto41 produto41, int quantidade){
        if (produto41.retirarEstoque(quantidade)){
            produtosCarrinho.add(produto41);
            quantidadeCarrinho.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index >= 0 && index < produtosCarrinho.size()){
            Produto41 produto41 = (Produto41) produtosCarrinho.get(index);
            produto41.devolverEstoque(quantidadeCarrinho.get(index));
            produtosCarrinho.remove(index);
            quantidadeCarrinho.remove(index);
            System.out.println("Produto removido do carrinho.");
            return;
        }
        System.out.println("Índice inválido.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel41 produto = produtosCarrinho.get(i);
            int quantidade = quantidadeCarrinho.get(i);
            System.out.println((1+i)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+total);
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            total+= produtosCarrinho.get(i).getPreco() * quantidadeCarrinho.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtosCarrinho.isEmpty();
    }

}
