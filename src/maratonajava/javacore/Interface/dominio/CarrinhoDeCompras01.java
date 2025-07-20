package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras01 {
    private List<Vendavel01> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void adicionarProdutos(Produto01 produto01, int quantidade){
        if (produto01.reduzirEstoque(quantidade)){
            produtos.add(produto01);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void removerProduto(int index){
        if (index >= 0 && index < produtos.size()){
            Produto01 produto01 = (Produto01) produtos.get(index);
            produto01.reduzirEstoque(-quantidades.get(index));
            produtos.remove(index);
            quantidades.remove(index);
            System.out.println("Produto removido do carrinho.");
        }else {
            System.out.println("Indice inválido.");
        }
    }

    public void exibirCarinho(){
        if (produtos.isEmpty()){
            System.out.println("Carinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel01 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.println("Produto:"+produto.getNome()+" x "+quantidade+" | R$"+(produto.getPreco()*quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$ "+total);

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
}
