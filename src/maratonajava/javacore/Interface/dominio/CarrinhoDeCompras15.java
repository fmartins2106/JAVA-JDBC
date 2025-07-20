package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras15 {
    List<Vendavel15> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto15 produto15, int quantidade){
        if (produto15.diminuirEstoque(quantidade)){
            produtos.add(produto15);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado ao carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice do produto não encontrado.");
            return;
        }
        Produto15 produto15 = (Produto15) produtos.get(index);
        produto15.devolvendoEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Dados removidos com sucesso.");
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi adicionado ao carrinho.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras.");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel15 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
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

}
