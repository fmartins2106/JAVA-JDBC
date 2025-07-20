package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.*;

public class CarrinhoDeCompras45 {
    private final Map<Produto45,Integer> carrinhoDeCompras = new LinkedHashMap<>();
    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void addProdutoCarrinho(Produto45 produto45, int quantidade){
        if (produto45.retirarEstoque(quantidade)){
            int quantidadeAtual = carrinhoDeCompras.getOrDefault(produto45,0);
            int novaQuantidade = quantidade + quantidadeAtual;
            carrinhoDeCompras.put(produto45,novaQuantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        List<Produto45> produtos = new ArrayList<>(carrinhoDeCompras.keySet());
        Produto45 produtoSelecionado = produtos.get(index);
        int quantidade = carrinhoDeCompras.remove(produtoSelecionado);
        produtoSelecionado.devolverParaEstoque(quantidade);
        System.out.println("Produto retirado do Carrinho.");
    }

    public void mostrarCarrinho(){
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
        System.out.println("Valor total do carrinho:"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (Map.Entry<Produto45,Integer> entry : carrinhoDeCompras.entrySet()){
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    public boolean estaVazio(){
        return carrinhoDeCompras.isEmpty();
    }

    public Map<Produto45, Integer> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }




}

