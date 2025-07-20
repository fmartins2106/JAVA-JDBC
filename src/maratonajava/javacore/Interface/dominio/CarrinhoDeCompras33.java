package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras33 {
        List<Vendavel33> produtoCarrinho = new ArrayList<>();
        List<Integer> quantidades = new ArrayList<>();

        public void addProduto(Produto33 produto33, int quantidade){
            if (produto33.retirarEstoque(quantidade)){
                produtoCarrinho.add(produto33);
                quantidades.add(quantidade);
                System.out.println("Produto adicionado no carrinho.");
            }
        }

        public void retirarCarrinho(int index){
            if (index >= 0 && index < produtoCarrinho.size()){
                Produto33 produto33 = (Produto33) produtoCarrinho.get(index);
                produto33.devolverEstoque(quantidades.get(index));
                produtoCarrinho.remove(index);
                quantidades.remove(index);
                System.out.println("Produto removido do carrinho.");
                return;
            }
            System.out.println("Nenhum produto encontrado com este número de indice.");
        }

        public static final DecimalFormat df = new DecimalFormat("0.00");

        public void mostrarCarrinho(){
            if (produtoCarrinho.isEmpty()){
                System.out.println("Nenhum produto no carrinho.");
                return;
            }
            double total = 0;
            for (int i = 0; i < produtoCarrinho.size(); i++) {
                Vendavel33  produto = produtoCarrinho.get(i);
                int quantidade = quantidades.get(i);
                System.out.print((1+i)+" - ");
                System.out.println("Produto:"+produto.getNome()+" |Quantidade"+quantidade+" |R$"+(produto.getPreco() * quantidade));
                total += produto.getPreco() * quantidade;
            }
            System.out.println("Total:R$"+df.format(total));

        }

        public double calcularTotal(){
            double total = 0;
            for (int i = 0; i < produtoCarrinho.size(); i++) {
                total += produtoCarrinho.get(i).getPreco() * quantidades.get(i);
            }
            return total;
        }

        public boolean estaVazio(){
            return produtoCarrinho.isEmpty();
        }

    public List<Vendavel33> getProdutoCarrinho() {
        return produtoCarrinho;
    }
}

