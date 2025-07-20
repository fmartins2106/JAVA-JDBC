package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras42 {
    private static final Scanner scanner = new Scanner(System.in);
    List<Vendavel42> produtosCarrinho = new ArrayList<>();
    List<Integer> quantidadeCarrinho = new ArrayList<>();

    public void addProdutoCarrinho(Produto42 produto42, int quantidade){
        if (produto42.retirarEstoque(quantidade)){
            produtosCarrinho.add(produto42);
            quantidadeCarrinho.add(quantidade);
            System.out.println("Produto adicionado no carrinho com sucesso.");
        }
    }

    public void retirarProdutoCarrinho(){
        if (getProdutosCarrinho().isEmpty()){
            System.out.println("Carrinho vazio.");
        }
        mostrarCarrinho();
        try {
            System.out.println("Digite o índice do produto:");
            int index = Integer.parseInt(scanner.nextLine().trim())-1;
            if (index < 0 || index >= produtosCarrinho.size()){
                System.out.println("Índice inválido.");
                return;
            }
            Produto42 produto42 = (Produto42) produtosCarrinho.get(index);
            produto42.devolverEstoque(quantidadeCarrinho.get(index));
            produtosCarrinho.remove(index);
            quantidadeCarrinho.remove(index);
            System.out.println("Produto retirado do carrinho.");
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite uma opção válida.");
        }

    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarCarrinho(){
        if (produtosCarrinho.isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            Vendavel42 produto = produtosCarrinho.get(i);
            int quantidade  = quantidadeCarrinho.get(i);
            System.out.print((1+i)+" - ");
            System.out.println("Nome:"+produto.getNome()+" |Quantidade:"+quantidade+" |Total- R$"+(produto.getPreco()*quantidade));
            total += produto.getPreco() * quantidade;
        }
        System.out.println("Total do carrinho R$:"+df.format(total));
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            total = produtosCarrinho.get(i).getPreco() * quantidadeCarrinho.get(i);
        }
        return total;
    }

    public boolean estaVazio(){
        return produtosCarrinho.isEmpty();
    }

    public List<Vendavel42> getProdutosCarrinho() {
        return produtosCarrinho;
    }
}
