package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras22 {
    List<Vendavel22> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addProduto(Produto22 produto22, int quantidade){
        if (produto22.retirarEstoque(quantidade)){
            produtos.add(produto22);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho com sucesso.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice inválido.");
            return;
        }
        Produto22 produto22 = (Produto22) produtos.get(index);
        produto22.reporEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Dados removidos com sucesso.");
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinhoDeCompras(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel22  produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }

    public double totalCompras(){
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
