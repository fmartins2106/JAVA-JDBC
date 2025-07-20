package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras25 {
    List<Vendavel25> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto25 produto25, int quantidade){
        if (produto25.diminuirEstoque(quantidade)){
            produtos.add(produto25);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado ao carrinho.");
        }
    }

    public void retirarCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice inválido.");
            return;
        }
        Produto25 produto25 = (Produto25) produtos.get(index);
        produto25.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Dados removidos com sucesso.");
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel25 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println("Produto:"+produto.getNome()+" |Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
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
