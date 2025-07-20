package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto45;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoDeComprasComMap02 {
    private final Map<Produto45,Integer> produto45IntegerMap = new LinkedHashMap<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private void addProdutoCarrinho(Produto45 produto45, int quantidade){
        if (produto45.retirarEstoque(quantidade)){
            int quantidadeAtual = produto45IntegerMap.getOrDefault(produto45,0);
            int novaQuantidade = quantidade + quantidadeAtual;
            produto45IntegerMap.put(produto45,novaQuantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    private void retirarProdutoCarrinho(int index){
        List<Produto45> produto45s = new ArrayList<>(produto45IntegerMap.keySet());
        Produto45 produtoSelecionado = produto45s.get(index);
        int quantidade = produto45IntegerMap.remove(produtoSelecionado);
        produtoSelecionado.devolverParaEstoque(quantidade);
        System.out.println("Produto removido do estoque.");
    }

    private void mostrarCarrinho(){
        if (produto45IntegerMap.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        int i = 1;
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : produto45IntegerMap.entrySet()){
            Produto45 produto45 = entry.getKey();
            int quantidade = entry.getValue();
            double subTotal = produto45.getPreco() * quantidade;
            System.out.println("Produto:"+produto45.getNome()+" |Quantidade:"+quantidade+" |Preço:R$"+produto45.getPreco());
            total += subTotal;
            i++;
        }
        System.out.println("Valor total do carrinho:R$"+df.format(total));
    }

    private double calcularTotal(){
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : produto45IntegerMap.entrySet()){
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

}
