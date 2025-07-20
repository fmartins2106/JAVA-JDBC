package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras08;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido08;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto08> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto08("notboook",3000,300));
        produtosDisponiveis.add(new Produto08("teclado gamer",230,300));
        produtosDisponiveis.add(new Produto08("mouse",100,2333));
        CarrinhoDeCompras08 carrinhoDeCompras08 = new CarrinhoDeCompras08();
        Pedido08 pedido08 = new Pedido08();
        while (true){
            System.out.println("[1] Adicionar produto ao carrinho.");
            System.out.println("[2] Remover produto do carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar o pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras08);
                        break;
                    case 2:
                        removerProduto(scanner,carrinhoDeCompras08);
                        break;
                    case 3:
                        carrinhoDeCompras08.exibirCarrinho();
                        break;
                    case 4:
                        pedido08.finalizarPedido(carrinhoDeCompras08);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");

                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto08> produtosDisponiveis, CarrinhoDeCompras08 carrinhoDeCompras08){
        System.out.println("Produtos disponíveis.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_________________________");
            System.out.println((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_________________________");
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
                carrinhoDeCompras08.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma valor válido para quantidade.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um produto válido.");
        }
    }

    public static void removerProduto(Scanner scanner, CarrinhoDeCompras08 carrinhoDeCompras08){
        carrinhoDeCompras08.exibirCarrinho();
        try {
            System.out.print("Digite um indice do produto:");
            int removerIndex = Integer.parseInt(scanner.nextLine());
            if (removerIndex < 0 || removerIndex > carrinhoDeCompras08.tamanhoCarrinho()){
                System.out.println("Indice inválido.");
                return;
            }
            carrinhoDeCompras08.removerProdutoCarrinho(removerIndex);
        }catch (NumberFormatException e){
            System.out.println("Indice inválido.");
        }
    }
}
