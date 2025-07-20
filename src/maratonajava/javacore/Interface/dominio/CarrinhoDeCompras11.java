package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras11 {
    private List<Vendavel11> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto11 produto11, int quantidade){
        if (produto11.retirarEstoque(quantidade)){
            produtos.add(produto11);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarCarrinho(int index){
        if (index >= 0 && index < produtos.size()){
            Produto11 produto11 = (Produto11) produtos.get(index);
            produto11.devolverEstoque(quantidades.get(index));
            produtos.remove(index);
            quantidades.remove(index);
            System.out.println("Produto removido com sucesso.");
        }
    }

    public void mostrarCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel11 produto = produtos.get(i);
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
