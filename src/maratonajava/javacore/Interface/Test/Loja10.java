package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras10;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido10;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja10 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto10> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto10("mouse",100,200));
        produtosDisponiveis.add(new Produto10("teclado gamer",230,100));
        produtosDisponiveis.add(new Produto10("notbook",100,200));
        CarrinhoDeCompras10 carrinhoDeCompras10 = new CarrinhoDeCompras10();
        Pedido10 pedido10 = new Pedido10();
        while (true){
            System.out.println("[1] Adicionar produto no carrinho.");
            System.out.println("[2] Remover produto do carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras10);
                        break;
                    case 2:
                        removerProdutos(scanner,carrinhoDeCompras10);
                        break;
                    case 3:
                        carrinhoDeCompras10.exibirCarrinho();
                        break;
                    case 4:
                        pedido10.finalizarPedido(carrinhoDeCompras10);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto10> produtosDisponiveis, CarrinhoDeCompras10 carrinhoDeCompras10){
        System.out.println("Produtos disponíveis.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("__________________________");
            System.out.println((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("__________________________");
        }
        try {
            System.out.println("Escolha um produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Opção inválida.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                Produto10 produtoSelecionado = produtosDisponiveis.get(produtoEscolhido);
                if (quantidade < Produto10.MENOR_ESTOQUE || quantidade > produtoSelecionado.getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras10.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public static void removerProdutos(Scanner scanner, CarrinhoDeCompras10 carrinhoDeCompras10){
        carrinhoDeCompras10.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto.");
            int removerIndice = Integer.parseInt(scanner.nextLine())-1;
            if (removerIndice < 0 || removerIndice > carrinhoDeCompras10.tamanhoCarrinho()){
                System.out.println("Produto não encontrado. Indice inválido.");
                return;
            }
            carrinhoDeCompras10.removerCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }
}
