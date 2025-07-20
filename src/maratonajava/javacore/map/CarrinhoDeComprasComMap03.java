package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto45;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoDeComprasComMap03 {
    private final Map<Produto45,Integer> carrinhoDeCompras = new LinkedHashMap<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private void addProdutoCarrinho(Produto45 produto45, int quantidade){
        if (produto45.retirarEstoque(quantidade)){
            int quantidadeAtual = carrinhoDeCompras.getOrDefault(produto45,0);
            int novaQuantidade = quantidade + quantidadeAtual;
            carrinhoDeCompras.put(produto45,novaQuantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    private void retirarProdutoCarrinho(int index){
        List<Produto45> produtos = new ArrayList<>(carrinhoDeCompras.keySet());
        Produto45 produtoSelecionado = produtos.get(index);
        int quantidade = carrinhoDeCompras.remove(produtoSelecionado);
        produtoSelecionado.devolverParaEstoque(quantidade);
        System.out.println("Produto removido do carrinho.");
    }

    private void mostrarCarrinho(){
        if (carrinhoDeCompras.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        int i = 1;
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : carrinhoDeCompras.entrySet()){
            Produto45 produto45 = entry.getKey();
            int quantidade = entry.getValue();
            double subTotal = produto45.getPreco() * quantidade;
            System.out.println(i+" - Produto:"+produto45.getNome()+" |Quantidade:"+quantidade+" |Preço:R$"+produto45.getPreco());
            total += subTotal;
            i++;
        }
        System.out.println("Valor total da compra:R$"+df.format(total));
    }

    private double calcularTotal(){
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : carrinhoDeCompras.entrySet()){
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

}
