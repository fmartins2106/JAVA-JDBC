package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarrinhoDeCompras43 {
    private final Map<Produto43,Integer> carrinhoDeCompras = new HashMap<>();
    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void addProdutoCarrinho(Produto43 produto43, int quantidade){
        if (produto43.retirarEstoque(quantidade)){
            carrinhoDeCompras.put(produto43,carrinhoDeCompras.getOrDefault(produto43,0)+quantidade);
            System.out.println("Produto adicionado no carrinho com sucesso.");
        }
    }

    public void retirarProdutoCarrinho(int index){
        Produto43 produtoSelecionado = (Produto43) carrinhoDeCompras.keySet().toArray()[index];
        int quantidade = carrinhoDeCompras.remove(produtoSelecionado);
        produtoSelecionado.devolverEstoque(quantidade);
        System.out.println("Produto retirado do carrinho com sucesso.");
    }

    public void mostrarCarrinho(){
        if (carrinhoDeCompras.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        int i = 1;
        double total = 0;
        for (Map.Entry<Produto43,Integer> entry : carrinhoDeCompras.entrySet()){
            Produto43 produto43 = entry.getKey();
            int quantidade = entry.getValue();
            double subtotal = produto43.getPreco() * quantidade;
            System.out.println(i+" - Nome:"+produto43.getNome()+" |Quantidade:"+quantidade+" |Total:R$"+df.format(subtotal));
            total += subtotal;
            i++;
        }
        System.out.println("Total do carrinho = R$"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (Map.Entry<Produto43,Integer> entry : carrinhoDeCompras.entrySet()){
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    public boolean estaVazio(){
        return carrinhoDeCompras.isEmpty();
    }

    public Map<Produto43,Integer> getCarrinhoDeCompras(){
        return carrinhoDeCompras;
    }

}
