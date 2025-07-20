package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras03 {
    private List<Vendavel03> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void adicionarProdutos(Produto03 produto03, int quantidade){
        if (produto03.reduzirEstoque(quantidade)){
            produtos.add(produto03);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void removerProduto(int index){
        if (index >= 0 && index < produtos.size()){
            Produto03 produto03 = (Produto03) produtos.get(index);
            produto03.reduzirEstoque(-quantidades.get(index));
            produtos.remove(index);
            quantidades.remove(index);
            System.out.println("Produto removido do carrinho.");
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
        System.out.println("Carrinho de compras.");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel03 produto = produtos.get(i);
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
