package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras24 {
    List<Vendavel24> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addProdutoCarrinho(Produto24 produto24, int quantidade){
        if (produto24.diminuirEstoque(quantidade)){
            produtos.add(produto24);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho com sucesso.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice não encontrado. Tente novamente.");
            return;
        }
        Produto24 produto24 = (Produto24) produtos.get(index);
        produto24.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Produto retirado do carrinho.");
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel24 produto = produtos.get(i);
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
            total += (produtos.get(i).getPreco() * quantidades.get(i));
        }
        return total;
    }

    public boolean estaVazio(){
        return produtos.isEmpty();
    }

}
