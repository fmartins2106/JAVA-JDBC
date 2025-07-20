package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto03> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto03("Notbook",3500,100));
        produtosDisponiveis.add(new Produto03("Mouse",30,100));
        produtosDisponiveis.add(new Produto03("Teclado gamer",230,100));
        CarrinhoDeCompras03 carrinhoDeCompras03 = new CarrinhoDeCompras03();
        Pedido03 pedido03 = new Pedido03();

        while (true){
            System.out.println("[1] Adicionar um produto no carrinho.");
            System.out.println("[2] Remover produtod o carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Escolha uma das opções:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutosCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras03);
                        break;
                    case 2:
                        removerProdutosCarrinho(scanner,carrinhoDeCompras03);
                        break;
                    case 3:
                        carrinhoDeCompras03.exibirCarrinho();
                        break;
                    case 4:
                        pedido03.finalizarPedido(carrinhoDeCompras03);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void addProdutosCarrinho(Scanner scanner, List<Produto03> produtosDisponiveis, CarrinhoDeCompras03 carrinhoDeCompras03){
        System.out.println("Produtos disponíveis.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_______________________");
            System.out.println((i+1)+ " - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_______________________");
        }
        try {
            System.out.print("Escolha um produto.");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Opção inválida.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade <= 0){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras03.adicionarProdutos(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Escolha um produto válido.");
        }
    }

    public static void removerProdutosCarrinho(Scanner scanner, CarrinhoDeCompras03 carrinhoDeCompras03){
        carrinhoDeCompras03.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto para remover:");
            int indexRemover =  Integer.parseInt(scanner.nextLine())-1;
            if (indexRemover < 0 || indexRemover >= carrinhoDeCompras03.tamanhoCarrinho()){
                System.out.println("Digite um número igual ou maior que 1.");
                return;
            }
            carrinhoDeCompras03.removerProduto(indexRemover);
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }
}
