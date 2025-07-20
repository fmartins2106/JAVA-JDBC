package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras20 {
    List<Vendavel20> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto20 produto20, int quantidade){
        if (produto20.diminuirEstoque(quantidade)){
            produtos.add(produto20);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado com sucesso.");
        }
    }

    public void retirarCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice inválido. Tente novamente.");
            return;
        }
        Produto20 produto20 = (Produto20) produtos.get(index);
        produto20.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Produto removido com sucesso.");
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi adicionado ao carrinho.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel20 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.print((i+1)+" - ");
            System.out.println(produto.getNome()+" | Quantidade:"+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total  = produto.getPreco() * quantidade;
        }
        System.out.println("Tota:R$"+df.format(total));
    }

    public double calculandoTotal(){
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
