package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras18 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    List<Vendavel18> produtos = new ArrayList<>();
    List<Integer> quantidades = new ArrayList<>();

    public void addCarrinho(Produto18 produto18, int quantidade){
        if (produto18.diminuirEstoque(quantidade)){
            produtos.add(produto18);
            quantidades.add(quantidade);
            System.out.println("Produto adicionado ao carrinho");
        }
    }

    public void retirarCarrinho(int index){
        if (index < 0 || index >= produtos.size()){
            System.out.println("Indice não encontrado. Tente novamente.");
            return;
        }
        Produto18 produto18 = (Produto18) produtos.get(index);
        produto18.devolverEstoque(quantidades.get(index));
        produtos.remove(index);
        quantidades.remove(index);
        System.out.println("Produto removido com sucesso.");
    }

    public void exibirCarrinho(){
        if (produtos.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        System.out.println("Carrinho de compras:");
        for (int i = 0; i < produtos.size(); i++) {
            Vendavel18 produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            System.out.println("Produto:"+produto.getNome()+" x "+quantidade+" |R$"+(produto.getPreco() * quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Tota carrinho:R$"+df.format(total));
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
