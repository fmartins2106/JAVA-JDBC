package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras10 {
    private List<Vendavel10> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto10 produto10, int quantidade){
        if (produto10.diminuirEstoque(quantidade)){
            produtos.add(produto10);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado ao carrinho.");
        }
    }

    public void removerCarrinho(int index){
        if (index >= 0 && index < produtos.size()){
            Produto10 produto10 = (Produto10) produtos.get(index);
            produto10.devolverEstoque(quantidades.get(index));
            produtos.remove(index);
            quantidades.remove(index);
            System.out.println("Produto removido do carrinho com sucesso.");
        }else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio. Nenhum produto foi adicionado ao carrinho.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras.");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel10 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.println("Produto:"+produto.getNome()+" x "+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+total);
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
