package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras19 {
    List<Vendavel19> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addProdutos(Produto19 produto19, int quantidade){
        if (produto19.retirarEstoque(quantidade)){
            produtos.add(produto19);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice inválido verifique.");
            return;
        }
        Produto19 produto19 = (Produto19) produtos.get(index);
        produto19.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Dados removidos com sucesso.");
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel19 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println("Produto:"+produto.getNome()+" x "+quantidade+" |R$"+(produto.getPreco() * (quantidade)));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+total);
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += (produtos.get(i).getPreco() * quantidades.get(i));
        }
        return  total;
    }

    public boolean estaVazio(){
        return produtos.isEmpty();
    }
}
