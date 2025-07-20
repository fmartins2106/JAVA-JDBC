package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras16 {
    private List<Vendavel16> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void addProdutoCarrinho(Produto16 produto16, int quantidade){
        if (produto16.redudirEstoque(quantidade)){
            produtos.add(produto16);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void removerProdutoCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice não encontrado.");
            return;
        }
        Produto16 produto16 = (Produto16) produtos.get(index);
        produto16.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        produto16.devolverEstoque(index);
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
            Vendavel16 produto = produtos.get(i);
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
