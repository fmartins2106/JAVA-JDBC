package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras42;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido42;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto42;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja42 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras42 carrinhoDeCompras42 = new CarrinhoDeCompras42();
    private static final Pedido42 pedido42 = new Pedido42();
    private static final List<Produto42> produtosDisponiveis = new ArrayList<>();

    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto42("notbook",2300,100));
        produtosDisponiveis.add(new Produto42("teclado gamer",233,200));
        produtosDisponiveis.add(new Produto42("Mouse",29,200));

        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            metodoOpcoes(opcao);
        }while (opcao != 5);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void addProdutoCarrinho(){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.println("Digite o índice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Índice inválido. Tente novamente.");
                return;
            }
            try {
                System.out.println("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getQuantidade()){
                    System.out.println("Quantidade inválida. Tente novamente.");
                    return;
                }
                carrinhoDeCompras42.addProdutoCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número válido para o índice.");
        }
    }


    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                addProdutoCarrinho();
                break;
            case 2:
                carrinhoDeCompras42.retirarProdutoCarrinho();
                break;
            case 3:
                carrinhoDeCompras42.mostrarCarrinho();
                break;
            case 4:
                pedido42.finalizarPedido(carrinhoDeCompras42);
                break;
            case 5:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar produto ao carrinho.");
        System.out.println("[2] Excluir produto do carrinho.");
        System.out.println("[3] Mostrar carrinho.");
        System.out.println("[4] Finalizar pedido.");
        System.out.println("[5] Sair.");
    }



}
