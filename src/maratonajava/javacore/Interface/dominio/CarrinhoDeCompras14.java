package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras14 {
    private List<Vendavel14> produtos = new ArrayList<>();
    private List<Integer> quantiades = new ArrayList<>();

    public void addCarrinho(Produto14 produto14, int quantidade){
        if (produto14.diminuirEstoque(quantidade)){
            produtos.add(produto14);
            quantiades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice do produto não encontrado. Tente novamente.");
            return;
        }
        Produto14 produto14 = (Produto14) produtos.get(index);
        produto14.aumentarEstoque(quantiades.get(index));
        produtos.remove(index);
        quantiades.remove(index);
        System.out.println("Produto retirado do carrinho.");
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi adicionado no carrinho.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras.");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel14 produto = produtos.get(i);
            int quantidade = quantiades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println("Produto:"+produto.getNome()+" x "+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+total);
    }

    public double calculartTotal(){
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco() * quantiades.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtos.isEmpty();
    }

}
