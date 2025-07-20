package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras05 {
    private List<Vendavel05> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void addProdutoCarrinho(Produto05 produto05, int quantidade){
        if (produto05.reduzirEstoque(quantidade)){
            produtos.add(produto05);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado ao carrinho.");
        }
    }

    public void removerProdutoCarrinho(int index){
        if (index > 0 && index < produtos.size()){
            Produto05 produto05 = (Produto05) produtos.get(index);
            produto05.reduzirEstoque(-quantidades.get(index));
            produtos.remove(index);
            quantidades.remove(index);
            System.out.println("Produtos removidos com sucesso.");
        }else {
            System.out.println("Número de indice inválido.");
        }
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi adicioando no carrinho.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras.");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel05 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.println("Produto:"+produto.getNome()+" x "+quantidade+" |R$"+(produto.getPreco() * quantidade));
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

    public boolean estaVazio(){
        return produtos.isEmpty();
    }

    public int tamanhoCarrinho(){
        return produtos.size();
    }
}
