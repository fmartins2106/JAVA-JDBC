package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras40 {
    List<Produto40> produtosCarrinho = new ArrayList<>();
    List<Integer> quantidadesCarrinho = new ArrayList<>();

    public void addProdutoCarrinho(Produto40 produto40, int quantidade){
        if (produto40.diminuirEstoque(quantidade)){
            produtosCarrinho.add(produto40);
            quantidadesCarrinho.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarCarrinho(int index){
        if (index >= 0 && index < produtosCarrinho.size()){
            Produto40 produto40 = (Produto40) produtosCarrinho.get(index);
            produto40.devolverEstoque(quantidadesCarrinho.get(index));
            produtosCarrinho.remove(index);
            quantidadesCarrinho.remove(index);
            System.out.println("Produto removido do carrinho.");
            return;
        }
        System.out.println("Indice inválido, produto removido.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel40 produto = produtosCarrinho.get(i);
            int quantidade = quantidadesCarrinho.get(i);
            System.out.print((1+i)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+produto.getPreco() * quantidade);
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            total += produtosCarrinho.get(i).getPreco() * quantidadesCarrinho.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtosCarrinho.isEmpty();
    }

}
