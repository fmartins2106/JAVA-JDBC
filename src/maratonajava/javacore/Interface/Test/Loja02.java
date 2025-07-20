package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras02;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido02;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto02> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto02(  "Notbook",3000,10));
        produtosDisponiveis.add(new Produto02("Mouse",100,100));
        produtosDisponiveis.add(new Produto02("teclado gamer",230,200));
        CarrinhoDeCompras02 carrinhoDeCompras02 = new CarrinhoDeCompras02();
        Pedido02 pedido02 = new Pedido02();

        while (true){
            System.out.println("[1] Adicionar o produto no carrinho.");
            System.out.println("[2] Remover produto do carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Escolha uma das opções:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras02);
                        break;
                    case 2:
                        removerProdutosCarrinho(scanner,carrinhoDeCompras02);
                        break;
                    case 3:
                        carrinhoDeCompras02.exibirCarrinho();
                        break;
                    case 4:
                        pedido02.finalizarPedido(carrinhoDeCompras02);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto02> produtosDisponiveis, CarrinhoDeCompras02 carrinhoDeCompras02){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("____________________________");
            System.out.println((i+1)+ " - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("____________________________");
        }
        try {
            System.out.print("Escolha um produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Opção inválida.");
                return;
            }
            try {
                System.out.print("Digite a quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade <= 0){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras02.adicionarProdutos(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Escolha um produto válido.");
        }
    }

    public static void removerProdutosCarrinho(Scanner scanner, CarrinhoDeCompras02 carrinhoDeCompras02){
        carrinhoDeCompras02.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto para remover:");
            int indexRemover = Integer.parseInt(scanner.nextLine())-1;
            if (indexRemover < 0 ||  indexRemover >= carrinhoDeCompras02.tamanhoCarrinho()){
                System.out.println("Digite um número igual ou maior que 1.");
                return;
            }
            carrinhoDeCompras02.removerProduto(indexRemover);
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }
}
