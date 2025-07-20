package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras12 {
    private List<Vendavel12> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void addProdutoCarrinho(Produto12 produto12, int quantidade){
        if (produto12.reduzirEstoque(quantidade)){
            produtos.add(produto12);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado ao carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index < 0 || index > produtos.size()){
            System.out.println("Produto não encontrado. Digite um indiice válido.");
            return;
        }
        Produto12 produto12 = (Produto12) produtos.get(index);
        produto12.reduzirEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        produto12.devolverEstoque(quantidades.get(index));
        System.out.println("Produto retirado do carrinho.");
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel12 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println("Produto:"+produto.getNome()+" x "+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total carrinho:R$"+total);
    }

    public double totalCarrinho(){
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco() * quantidades.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtos.isEmpty();
    }

    public int tamanhoCarrinho(){
        return produtos.size();
    }
}
