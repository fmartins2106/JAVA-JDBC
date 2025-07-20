package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras07;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido07;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto07> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto07("notBook",3500,300));
        produtosDisponiveis.add(new Produto07("Mouse",50,323));
        produtosDisponiveis.add(new Produto07("Teclado gamer",239,1000));
        CarrinhoDeCompras07 carrinhoDeCompras07 = new CarrinhoDeCompras07();
        Pedido07 pedido07 = new Pedido07();

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
                        addProdutosCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras07);
                        break;
                    case 2:
                        removerProdutoCarrinho(scanner,carrinhoDeCompras07);
                        break;
                    case 3:
                        carrinhoDeCompras07.exibirCarrinho();
                        break;
                    case 4:
                        pedido07.finalizarPedido(carrinhoDeCompras07);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutosCarrinho(Scanner scanner, List<Produto07> produtosDisponiveis, CarrinhoDeCompras07 carrinhoDeCompras07){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_____________________________");
            System.out.println((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_____________________________");
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
                carrinhoDeCompras07.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Quantidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Indice inválido. Produto não encontrado.");
        }
    }

    public static void removerProdutoCarrinho(Scanner scanner, CarrinhoDeCompras07 carrinhoDeCompras07){
        carrinhoDeCompras07.exibirCarrinho();
        try {
            System.out.print("Digite um indice do produto para remover:");
            int indexRemover = Integer.parseInt(scanner.nextLine());
            if (indexRemover < 0 || indexRemover > carrinhoDeCompras07.tamanhoCarrinho()){
                System.out.println("Indice inválido.");
                return;
            }
            carrinhoDeCompras07.removerProdutoCarrinho(indexRemover);
        }catch (NumberFormatException e){
            System.out.println("Indice inválido.");
        }
    }
}
