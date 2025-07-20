package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras17 {
     List<Vendavel17> produtos = new ArrayList<>();
     List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto17 produto17, int quantidade){
        if (produto17.diminuirEstoque(quantidade)){
            produtos.add(produto17);
            quantidades.add(quantidade);
            System.out.println("Produ adicionado no carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice não encontrado. Tente novamente.");
            return;
        }
        Produto17 produto17 = (Produto17) produtos.get(index);
        produtos.remove(index);
        quantidades.remove(index);
        produto17.devolverEstoque(quantidades.get(index));
        System.out.println("Produto removido do carrinho.");
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel17 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println("Produto:"+produto.getNome()+" x " +quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+total);
    }

    public double totalCarrinho(){
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total+= produtos.get(i).getPreco() * quantidades.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtos.isEmpty();
    }
}
