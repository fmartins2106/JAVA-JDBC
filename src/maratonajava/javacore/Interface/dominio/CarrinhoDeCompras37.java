package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras37 {
    private List<Vendavel37> produtosCarrinho = new ArrayList<>();
    private List<Integer> quantidadeCarrinho = new ArrayList<>();
    
    public void addCarrinho(Produto37 produto37, int quantidade){
        if (produto37.retirarEstoque(quantidade)){
            produtosCarrinho.add(produto37);
            quantidadeCarrinho.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }
    
    public void retirarProdutoCarrinho(int index){
        if (index >= 0 && index < produtosCarrinho.size()){
            Produto37 produto37 = (Produto37) produtosCarrinho.get(index);
            produto37.devolverEstoque(quantidadeCarrinho.get(index));
            produtosCarrinho.remove(index);
            quantidadeCarrinho.remove(index);
            System.out.println("Dados removidos com sucesso.");
            return;
        }
        System.out.println("Indice inválido.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibiCarrinho(){
        if (quantidadeCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        for (int i = 0; i < quantidadeCarrinho.size(); i++) {
            Vendavel37 produto = produtosCarrinho.get(i);
            int quantidade = quantidadeCarrinho.get(i);
            System.out.print((1+i)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            total += produtosCarrinho.get(i).getPreco() * quantidadeCarrinho.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtosCarrinho.isEmpty();
    }

}
