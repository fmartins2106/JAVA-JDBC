package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras30{
    List<Vendavel30> produtosCarrinho = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto30 produto30, int quantidade){
        if (produto30.retirarEstoque(quantidade)){
            produtosCarrinho.add(produto30);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index < 0 || index >= produtosCarrinho.size()){
            System.out.println("Indice inválido.");
        }
        Produto30 produto30 = (Produto30) produtosCarrinho.get(index);
        produto30.retornarEstoque(quantidades.get(index));
        produtosCarrinho.remove(index);
        quantidades.remove(index);
        System.out.println("Produto removido com sucesso.");
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
        }
        double total = 0;
        System.out.println("Carrinho de compras.");
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel30 produtos = produtosCarrinho.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((1+i)+" - ");
            System.out.println("Produto:"+produtos.getNome()+" |Quantidade:"+quantidade+" |R$"+(produtos.getPreco() * quantidade));
            total += produtos.getPreco() * quantidade;
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
