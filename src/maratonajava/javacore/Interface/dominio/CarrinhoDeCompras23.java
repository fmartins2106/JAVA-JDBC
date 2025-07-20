package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras23 {
    List<Vendavel23> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto23 produto23, int quantidade){
        if (produto23.retirarEstoque(quantidade)){
            produtos.add(produto23);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado com sucesso.");
        }
    }

    public void retirarCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice não encontrado.");
            return;
        }
        Produto23 produto23 = (Produto23) produtos.get(index);
        produto23.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Produto removido com sucesso.");
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinhoCompras(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel23 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total:R$"+df.format(total));
    }

    public double calcularTota(){
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
