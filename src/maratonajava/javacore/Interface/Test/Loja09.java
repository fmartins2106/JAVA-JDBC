package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras09;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido09;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja09 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto09> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto09("notbook",3500,200));
        produtosDisponiveis.add(new Produto09("Teclado gamer",230,100));
        produtosDisponiveis.add(new Produto09("mouse",29,299));
        CarrinhoDeCompras09 carrinhoDeCompras09 = new CarrinhoDeCompras09();
        Pedido09 pedido09 = new Pedido09();
        while (true){
            System.out.println("[1] Adicionar produto ao carrinho.");
            System.out.println("[2] Remover produto do carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                       addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras09);
                       break;
                    case 2:
                        removerProdutos(scanner,carrinhoDeCompras09);
                        break;
                    case 3:
                        carrinhoDeCompras09.exibirCarrinho();
                        break;
                    case 4:
                        pedido09.finalizarPedido(carrinhoDeCompras09);
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

    public static void addProdutoCarrinho(Scanner scanner, List<Produto09> produtosDisponiveis, CarrinhoDeCompras09 carrinhoDeCompras09){
        System.out.println("Produtos disponíveis.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("______________________");
            System.out.println((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("______________________");
        }
        try {
            System.out.print("Escolha um produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine())-1;
            if (produtoEscolhido < 0 || produtoEscolhido > produtosDisponiveis.size()){
                System.out.println("Opção inválida.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < 0){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras09.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um produto válido.");
        }
    }

    public static void removerProdutos(Scanner scanner, CarrinhoDeCompras09 carrinhoDeCompras09){
        carrinhoDeCompras09.exibirCarrinho();
        try {
            System.out.print("Digite um indice de produto:");
            int removerIndex = Integer.parseInt(scanner.nextLine())-1;
            if (removerIndex < 0 || removerIndex > carrinhoDeCompras09.tamanhoCarrinho()){
                System.out.println("Indice inválido.");
                return;
            }
            carrinhoDeCompras09.removerCarrinho(removerIndex);
        }catch (NumberFormatException e){
            System.out.println("Indice inválido.");
        }
    }
}
