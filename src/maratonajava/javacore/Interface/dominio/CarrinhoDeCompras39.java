package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras39 {
    List<Vendavel39> produtosCarrinho = new ArrayList<>();
    List<Integer> quantidadeProdutos = new ArrayList<>();

    public void addCarrinho(Produto39 produto39, int quantidade){
        if (produto39.retirarProdutoEstoque(quantidade)){
            produtosCarrinho.add(produto39);
            quantidadeProdutos.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarCarrinho(int index){
        if (index >= 0 && index < produtosCarrinho.size()){
            Produto39 produto39 = (Produto39) produtosCarrinho.get(index);
            produto39.devolverEstoque(quantidadeProdutos.get(index));
            produtosCarrinho.remove(index);
            quantidadeProdutos.remove(index);
            System.out.println("Produto removido do carrinho.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarCarrinhoDeCompras(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras.");
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel39 produto = produtosCarrinho.get(i);
            int quantidade = quantidadeProdutos.get(i);
            System.out.print((1+i)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            total += produtosCarrinho.get(i).getPreco() * quantidadeProdutos.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtosCarrinho.isEmpty();
    }
}
