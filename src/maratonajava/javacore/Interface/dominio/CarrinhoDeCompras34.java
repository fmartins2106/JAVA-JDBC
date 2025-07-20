package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras34{
    List<Vendavel34> produtosCarrinho = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto34 produto34, int quantidade){
        if (produto34.retirarEstoque(quantidade)){
            produtosCarrinho.add(produto34);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarCarrinho(int index){
        if (index >= 0 && index < produtosCarrinho.size()){
            Produto34 produto34 = (Produto34) produtosCarrinho.get(index);
            produto34.devolverEstoque(quantidades.get(index));
            produtosCarrinho.remove(index);
            quantidades.remove(index);
            System.out.println("Dados removidos com sucesso.");
            return;
        }
        System.out.println("Indice inválido.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel34 produto = produtosCarrinho.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((1+i)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |Preço:R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            total += (produtosCarrinho.get(i).getPreco() * quantidades.get(i));
        }
        return total;
    }

    public boolean estaVazio(){
        return produtosCarrinho.isEmpty();
    }
}
