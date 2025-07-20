package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja19 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto19> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto19("NotBook",3300,200));
        produtosDisponiveis.add(new Produto19("Mouse",60,200));
        produtosDisponiveis.add(new Produto19("teclado",230,200));
        CarrinhoDeCompras19 carrinhoDeCompras19 = new CarrinhoDeCompras19();
        Pedido19 pedido19 = new Pedido19();
        while (true){
            System.out.println("[1] Adicionar produto ao carrinho.");
            System.out.println("[2] Remover produto carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProduto(scanner,produtosDisponiveis,carrinhoDeCompras19);
                        break;
                    case 2:
                        removerProdutoCarrinho(carrinhoDeCompras19);
                        break;
                    case 3:
                        carrinhoDeCompras19.exibirCarrinho();
                        break;
                    case 4:
                        pedido19.finalizarPedido(carrinhoDeCompras19);
                        break;
                    case 5:
                        System.out.println(">>>Finalizar pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProduto(Scanner scanner, List<Produto19> produtosDisponiveis, CarrinhoDeCompras19 carrinhoDeCompras19){
        System.out.println("Lista de produtos disponívels:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_______________________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_______________________________________");
        }
        try {
            System.out.print("Digite o indice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido > produtosDisponiveis.size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras19.addProdutos(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProdutoCarrinho(CarrinhoDeCompras19 carrinhoDeCompras19){
        carrinhoDeCompras19.exibirCarrinho();
        System.out.print("Digite o indice do produto a ser removido:");
        int removerIndex = Integer.parseInt(scanner.nextLine().trim())-1;
        carrinhoDeCompras19.retirarCarrinho(removerIndex);
        System.out.println("Produto removido com sucesso.");
    }


}
