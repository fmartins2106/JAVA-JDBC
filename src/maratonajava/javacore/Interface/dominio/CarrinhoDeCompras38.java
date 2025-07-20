package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras38 {
    List<Vendavel38> produtosCarrinho = new ArrayList<>();
    List<Integer> quantidadeCarrinho = new ArrayList<>();

    public void addCarrinho(Produto38 produto38, int quantidade){
        if (produto38.diminuirEstoque(quantidade)){
            produtosCarrinho.add(produto38);
            quantidadeCarrinho.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index >= 0 && index < produtosCarrinho.size()){
            Produto38 produto38 = (Produto38) produtosCarrinho.get(index);
            produto38.devolverEstoque(quantidadeCarrinho.get(index));
            produtosCarrinho.remove(index);
            quantidadeCarrinho.remove(index);
            System.out.println("Produto retirado do carrinho.");
            return;
        }
        System.out.println("Indice inválido. Tente novamente.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Nenhum produto no carrinho.");
            return;
        }
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel38 produto = produtosCarrinho.get(i);
            int quantidade = quantidadeCarrinho.get(i);
            System.out.print((i+1)+" - ");
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
        return quantidadeCarrinho.isEmpty();
    }

    public List<Vendavel38> getProdutosCarrinho() {
        return produtosCarrinho;
    }
}
