package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras01;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido01;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto01> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto01("Notbook",3500,5));
        produtosDisponiveis.add(new Produto01("Teclado gamer",230,50));
        produtosDisponiveis.add(new Produto01("Mouse sem fio",100,200));
        CarrinhoDeCompras01 carrinhoDeCompras01 = new CarrinhoDeCompras01();
        Pedido01 pedido01 = new Pedido01();

        while (true){
            System.out.println("[1] Adicionar o produto ao carrinho.");
            System.out.println("[2] Remover produto do carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Escolha uma das opções:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarinho(scanner,produtosDisponiveis,carrinhoDeCompras01);
                        break;
                    case 2:
                        removerProdutoCarrinho(scanner,carrinhoDeCompras01);
                        break;
                    case 3:
                        carrinhoDeCompras01.exibirCarinho();
                        break;
                    case 4:
                        pedido01.finalizarPedido(carrinhoDeCompras01);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizar a loja.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void addProdutoCarinho(Scanner scanner, List<Produto01> produtosDisponiveis, CarrinhoDeCompras01 carrinhoDeCompras){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_________________________________________");
            System.out.println((i+1)+ " - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_________________________________________");

        }
        System.out.print("Escolha um produto:");
        int produtoEscolhido = scanner.nextInt() -1;

        if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
            System.out.println("Opção inválida.");
            return;
        }
        scanner.nextLine();
        try {
            System.out.print("Digite a quantidade:");
            int quantidade = Integer.parseInt(scanner.nextLine());
            if (quantidade <= 0){
                System.out.println("Quantidade inválida.");
                return;
            }
            carrinhoDeCompras.adicionarProdutos(produtosDisponiveis.get(produtoEscolhido),quantidade);
        }catch (NumberFormatException e){
            System.out.println("Digite uma quantidade válida.");
        }
    }

    public static void removerProdutoCarrinho(Scanner scanner, CarrinhoDeCompras01 carrinhoDeCompras01){
        carrinhoDeCompras01.exibirCarinho();
        try {
            System.out.print("Digite o índice do produto para remover:");
            int indexRemover = Integer.parseInt(scanner.nextLine())-1;
            if (indexRemover < 1){
                System.out.println("Digite um número maior que 1.");
                return;
            }
            carrinhoDeCompras01.removerProduto(indexRemover);
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }
}
