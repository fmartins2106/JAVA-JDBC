package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras29 {
    List<Vendavel29> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addProdutoCarrinho(Produto29 produto29, int quantidade){
        if (produto29.diminuirEstoque(quantidade)){
            produtos.add(produto29);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado no carrinho com sucesso.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi adicionado no carrinho.");
            return;
        }
        Produto29 produto29 = (Produto29) produtos.get(index);
        produto29.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Produto removido do carrinho.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi adicionado no carrinho.");
            return;
        }
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel29 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco()*quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }

    public double calcularTotal(){
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
