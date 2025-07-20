package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto45;
import academy.devdojo.maratonajava.javacore.stream.ProdutoStrema01;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoDeComprasComMap05 {

    private final Map<Produto45,Integer> carrinhoDeCompreas = new LinkedHashMap<>();

    private void addProdutoCarrinho(Produto45 produto45, int quantidade){
        if (produto45.retirarEstoque(quantidade)){
            int quantidadeAtual = carrinhoDeCompreas.getOrDefault(produto45,0);
            int novaQuantidade = quantidade + quantidadeAtual;
            carrinhoDeCompreas.put(produto45,novaQuantidade);
            System.out.println("Produto adicioando no carrinho.");
        }
    }

    private void removerProdutoCarrinho(int index){
        List<Produto45> produto45Map = new ArrayList<>(carrinhoDeCompreas.keySet());
        Produto45 produtoSelecionado = produto45Map.get(index);
        int quantidade = carrinhoDeCompreas.remove(produtoSelecionado);
        produtoSelecionado.devolverParaEstoque(quantidade);
        System.out.println("Produto retirado do carrinho.");
    }

    private void mostrarCarrinho(){
        if (carrinhoDeCompreas.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        int i = 1;
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : carrinhoDeCompreas.entrySet()){
            Produto45 produto45 = entry.getKey();
            int quantidade = entry.getValue();
            double subTotal = produto45.getPreco() * quantidade;
            System.out.println(i+ " - Produto:"+produto45.getNome()+" |Quantidade:"+quantidade+" |Preço:R$"+produto45.getPreco());
            total += subTotal;
            i ++;
        }
    }

    private double calcularTotal(){
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : carrinhoDeCompreas.entrySet()){
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

}
