package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras04;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido04;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto04> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto04("Notbook",3000,100));
        produtosDisponiveis.add(new Produto04("Mouse",100,299));
        produtosDisponiveis.add(new Produto04("Teclado gamer",102,2222));
        CarrinhoDeCompras04 carrinhoDeCompras04 = new CarrinhoDeCompras04();
        Pedido04 pedido04 = new Pedido04();

        while (true){
            System.out.println("[1] Adicionar um produto no carrinho.");
            System.out.println("[2] Remover produto do carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Escolha uma das opções:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras04);
                        break;
                    case 2:
                        removerProdutoCarrinho(scanner,carrinhoDeCompras04);
                        break;
                    case 3:
                        carrinhoDeCompras04.exibirCarrinho();
                        break;
                    case 4:
                        pedido04.finalizarPedido(carrinhoDeCompras04);
                        break;
                    case 5:
                        System.out.println(">>>Finalizar programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto04> produtosDisponiveis, CarrinhoDeCompras04 carrinhoDeCompras04){
        System.out.println("Produtos disponíveis.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_______________________");
            System.out.println((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_______________________");
        }
        try {
            System.out.print("Escolha um produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Opção inválida.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade =  Integer.parseInt(scanner.nextLine());
                if (quantidade <= 0){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras04.adicionarProdutos(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Quatidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Escolha um produto válido.");
        }
    }

    public static void removerProdutoCarrinho(Scanner scanner, CarrinhoDeCompras04 carrinhoDeCompras04){
        carrinhoDeCompras04.exibirCarrinho();
        try {
            System.out.print("Digite um indice do produto para remover:");
            int indexRemover = Integer.parseInt(scanner.nextLine())-1;
            if (indexRemover < 0 || indexRemover >= carrinhoDeCompras04.tamanhoCarrinho()){
                System.out.println("Digite um número válido.");
                return;
            }
            carrinhoDeCompras04.removerProdutoCarrinho(indexRemover);
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }
}
