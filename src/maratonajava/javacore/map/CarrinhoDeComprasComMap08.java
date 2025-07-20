package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto45;

import java.text.DecimalFormat;
import java.util.*;

public class CarrinhoDeComprasComMap08 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static Map<Produto45,Integer> carrinhoDeCompras = new LinkedHashMap<>();

    public void addProdutoCarrinho(Produto45 produto45, int quantidade){
        if (produto45.retirarEstoque(quantidade)){
            int quantidadeAtual = carrinhoDeCompras.getOrDefault(produto45,0);
            int novaQuantidade = quantidade + quantidadeAtual;
            carrinhoDeCompras.put(produto45,novaQuantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void removerProdutoCarrinho(int index){
        List<Produto45> produtos = new ArrayList<>(carrinhoDeCompras.keySet());
        Produto45 produtoSelecionado = produtos.get(index);
        int quantidade = carrinhoDeCompras.remove(produtoSelecionado);
        produtoSelecionado.devolverParaEstoque(quantidade);
    }

    public void mostrarCarrinhoCompras(){
        if (carrinhoDeCompras.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        int i = 0;
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : carrinhoDeCompras.entrySet()){
            Produto45 produto45 = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println(i+" - Produto:"+produto45.getNome()+" |Quantidade:"+quantidade+" |Preço:R$"+produto45.getPreco());
            double subTotal = produto45.getPreco() * quantidade;
            i ++;
            total += subTotal;
        }
        System.out.println("Total:R$"+total);
    }

    public double calcularTotal(){
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : carrinhoDeCompras.entrySet()){
            total += entry.getValue() * entry.getKey().getPreco();
        }
        return total;
    }

}
