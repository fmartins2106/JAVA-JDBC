package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto05> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto05("Notbook",4999,499));
        produtosDisponiveis.add(new Produto05("Mouse",100,1200));
        produtosDisponiveis.add(new Produto05("Teclado Gamer",250,200));
        CarrinhoDeCompras05 carrinhoDeCompras05 = new CarrinhoDeCompras05();
        Pedido05 pedido05 = new Pedido05();

        while (true){
            System.out.println("[1] Adicionar produto carrinho.");
            System.out.println("[2] Remover produto carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Escolha uma das opções:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutosCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras05);
                        break;
                    case 2:
                        removerProdutoCarrinho(scanner,carrinhoDeCompras05);
                        break;
                    case 3:
                        carrinhoDeCompras05.exibirCarrinho();
                        break;
                    case 4:
                        pedido05.finalizarPedido(carrinhoDeCompras05);
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

    public static void addProdutosCarrinho(Scanner scanner, List<Produto05> produtosDisponiveis, CarrinhoDeCompras05 carrinhoDeCompras05){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("______________________");
            System.out.println((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("______________________");
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
                carrinhoDeCompras05.addProdutoCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProdutoCarrinho(Scanner scanner, CarrinhoDeCompras05 carrinhoDeCompras05){
        carrinhoDeCompras05.exibirCarrinho();
        try {
            System.out.print("Digite um indice do produto para remover.");
            int indexRemover =  Integer.parseInt(scanner.nextLine())-1;
            if (indexRemover < 0 || indexRemover >= carrinhoDeCompras05.tamanhoCarrinho()){
                System.out.println("Digite um número válido.");
                return;
            }
            carrinhoDeCompras05.removerProdutoCarrinho(indexRemover);
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }
}
