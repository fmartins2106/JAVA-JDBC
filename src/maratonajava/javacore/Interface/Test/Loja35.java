package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras35;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido35;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto35;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja35 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras35 carrinhoCompras = new CarrinhoDeCompras35();
    private static final List<Produto35> produtosDisponiveis = new ArrayList<>();
    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto35("Notebook",2300,300));
        produtosDisponiveis.add(new Produto35("Teclado",340,300));
        produtosDisponiveis.add(new Produto35("Mouse",29.39,300));
        Pedido35 pedido35 = new Pedido35();
        while (true){
            try {
                System.out.println("[1] Adicionar produto no carrinho.");
                System.out.println("[2] Remover produto do carrinho.");
                System.out.println("[3] Mostrar carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho();
                        break;
                    case 2:
                        removerProduto();
                        break;
                    case 3:
                        carrinhoCompras.mostrarCarrinho();
                        break;
                    case 4:
                        pedido35.finalizarPedido(carrinhoCompras);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Erro. Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void addProdutoCarrinho(){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Indice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Produto não encontrado.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida, tente novamente.");
                    return;
                }
                carrinhoCompras.addProduto(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para quantidade");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido para indice.");
        }
    }

    public static void removerProduto(){
        if (carrinhoCompras.estaVazio()){
            System.out.println("Carrinho de compras está vazio.");
            return;
        }
        carrinhoCompras.mostrarCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoCompras.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido para o indice.");
        }
    }




}
