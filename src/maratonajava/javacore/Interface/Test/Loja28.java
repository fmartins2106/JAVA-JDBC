package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras28;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido28;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto28> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto28("NotBook",3999,300));
        produtosDisponiveis.add(new Produto28("Teclado",339,300));
        produtosDisponiveis.add(new Produto28("Mouse",39,300));
        CarrinhoDeCompras28 carrinhoDeCompras28 = new CarrinhoDeCompras28();
        Pedido28 pedido28 = new Pedido28();
        while (true){
            try {
                System.out.println("[1] Adicionar produto no carrinho.");
                System.out.println("[2] Retirar produto do carrinho.");
                System.out.println("[3] Mostrar carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras28);
                        break;
                    case 2:
                        retirarProdutoCarrinho(scanner,carrinhoDeCompras28);
                        break;
                    case 3:
                        carrinhoDeCompras28.exibirCarrinho();
                        break;
                    case 4:
                        pedido28.finalizarPedido(carrinhoDeCompras28);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto28> produtosDiponiveis, CarrinhoDeCompras28 carrinhoDeCompras28){
        System.out.println("Produtos disponíveis.");
        for (int i = 0; i < produtosDiponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDiponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice do produto.");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido <= produtosDiponiveis.size()){
                System.out.println("Nenhum produto foi encontrado. Indice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade >= produtosDiponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras28.addCarrinho(produtosDiponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public static void retirarProdutoCarrinho(Scanner scanner, CarrinhoDeCompras28 carrinhoDeCompras28){
        carrinhoDeCompras28.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim());
            carrinhoDeCompras28.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Erro: digite um indice válido.");
        }
    }

}
