package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto34;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto45;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoDeComprasComMap07 {

    Map<Produto45,Integer> produtosCarrinho = new LinkedHashMap<>();

    public void addProdutoCarrinho(Produto45 produto45, int quantidade){
        if (produto45.retirarEstoque(quantidade)){
            int quantidadeAtual = produtosCarrinho.getOrDefault(produto45,0);
            int novaQuantidade = quantidade + quantidadeAtual;
            produtosCarrinho.put(produto45,novaQuantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        List<Produto45> produto45 = new ArrayList<>(produtosCarrinho.keySet());
        Produto45 produtoSelecionado = produto45.get(index);
        int quantidade = produtosCarrinho.remove(produtoSelecionado);
        produtoSelecionado.devolverParaEstoque(quantidade);
        System.out.println("Produto retirado do carrinho.");
    }

    public void mostrarCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        int i = 0;
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : produtosCarrinho.entrySet()){
            Produto45 produto45 = entry.getKey();
            int quantidade = entry.getValue();
            double subTotal = produto45.getPreco() * quantidade;
            System.out.println(i+" - Produto:"+produto45.getNome()+" |Quantidade:"+produto45.getEstoque()+" |Preço:R$"+produto45.getPreco());
            i++;
            total += subTotal;
        }
        System.out.println("Total:R$"+total);
    }

    public double calcularValorTotal(){
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : produtosCarrinho.entrySet()){
            total += entry.getValue() * entry.getKey().getPreco();
        }
        return total;
    }



}
