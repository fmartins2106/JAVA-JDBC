package academy.devdojo.maratonajava.javacore.Interface.dominio;

import javax.swing.plaf.PanelUI;
import java.text.DecimalFormat;
import java.util.*;

public class CarrinhoDeCompras44 {
    private final Map<Produto44,Integer> carrinhoDeCompras = new LinkedHashMap<>();
    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void addProdutoCarrinho(Produto44 produto44, int quantidade){
        if (produto44.retirarEstoque(quantidade)){
            carrinhoDeCompras.put(produto44,carrinhoDeCompras.getOrDefault(produto44,0)+quantidade);
            System.out.println("Produto adicionado no carrinho com sucesso.");
        }
    }
    public void retirarProdutoCarrinho(int index){
        List<Produto44> produtos = new ArrayList<>(carrinhoDeCompras.keySet());
        Produto44 produtoSelecionado = produtos.get(index);
        int quantidade = carrinhoDeCompras.remove(produtoSelecionado);
        produtoSelecionado.devolverEstoque(quantidade);
        System.out.println("Produto retirado do Carrinho.");
    }

    public void mostrarCarrinho(){
        if (carrinhoDeCompras.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        int i = 1;
        double total = 0;
        for (Map.Entry<Produto44,Integer> entry : carrinhoDeCompras.entrySet()){
            Produto44 produto44 = entry.getKey();
            int quantidade = entry.getValue();
            double subTotal = produto44.getPreco() * quantidade;
            System.out.println(i+" - Produto:"+produto44.getNome()+" |Quantidade:"+quantidade+" |Preço:R$"+produto44.getPreco());
            total += subTotal;
            i++;
        }
        System.out.println("Valor total do carrinho:"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (Map.Entry<Produto44,Integer> entry : carrinhoDeCompras.entrySet()){
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    public boolean estaVazio(){
        return carrinhoDeCompras.isEmpty();
    }

    public Map<Produto44, Integer> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }
}
