package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras13 {
    private List<Vendavel13> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void addProdutoCarrinho(Produto13 produto13, int quantidade){
        if (produto13.reduzirEstoque(quantidade)){
            produtos.add(produto13);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado com sucesso.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        Produto13 produto13 = (Produto13) produtos.get(index);
        produto13.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Produto removido com sucesso.");
    }

    public void mostrarCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto no carrinho.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel13 produto = produtos.get(i);
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
