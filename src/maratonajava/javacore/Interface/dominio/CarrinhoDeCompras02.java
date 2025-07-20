package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras02 {
    private List<Vendavel02> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void adicionarProdutos(Produto02 produto02, int quantidade){
        if (produto02.reduzirEstoque(quantidade)){
            produtos.add(produto02);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void removerProduto(int index){
        if ( index >= 0 && index < produtos.size()){
            Produto02 produto02 = (Produto02) produtos.get(index);
            produto02.reduzirEstoque(-quantidades.get(index));
            produtos.remove(index);
            quantidades.remove(index);
            System.out.println("Produtos removidos do carrinho.");
        }else {
            System.out.println("Indice inválido.");
        }
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel02 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.println("Produto:"+produto.getNome()+ " x "+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+total);
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco() * quantidades.get(i);
        }
        return total;
    }

    public boolean estaVaizio(){
        return produtos.isEmpty();
    }

    public int tamanhoCarrinho(){
        return produtos.size();
    }

}
