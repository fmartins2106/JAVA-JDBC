package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras35 {
    List<Vendavel35> produtosCarrinho = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addProduto(Produto35 produto35, int quantidade){
        if (produto35.diminuirEstoque(quantidade)){
            produtosCarrinho.add(produto35);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (index >= 0 && index < produtosCarrinho.size()){
            Produto35 produto35 = (Produto35) produtosCarrinho.get(index);
            produto35.retornarAoEstoque(quantidades.get(index));
            produtosCarrinho.remove(index);
            quantidades.remove(index);
            System.out.println("Dados removidos com sucesso.");
            return;
        }
        System.out.println("Indice não encontrado. Tente novamente.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel35 produto = produtosCarrinho.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((1+i)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }


    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            total += produtosCarrinho.get(i).getPreco() * quantidades.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtosCarrinho.isEmpty();
    }

}
