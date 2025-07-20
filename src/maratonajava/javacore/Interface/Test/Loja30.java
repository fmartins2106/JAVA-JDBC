package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras30;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido30;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja30 {
    private static final Scanner  scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto30> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto30("Notbook",2300,200));
        produtosDisponiveis.add(new Produto30("Teclado",230,200));
        produtosDisponiveis.add(new Produto30("Mouse",20,300));
        CarrinhoDeCompras30 carrinhoDeCompras30 = new CarrinhoDeCompras30();
        Pedido30 pedido30 = new Pedido30();

        while (true){
            try {
                System.out.println("[1] Adicionar produto no carrinho.");
                System.out.println("[2] Retirar produto do carrinho.");
                System.out.println("[3] Mostrar carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras30);
                        break;
                    case 2:
                        retirarProdutoCarrinho(carrinhoDeCompras30);
                        break;
                    case 3:
                        carrinhoDeCompras30.exibirCarrinho();
                        break;
                    case 4:
                        pedido30.finalizarPedido(carrinhoDeCompras30);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizar pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto30> produtosDisponiveis, CarrinhoDeCompras30 carrinhoDeCompras30){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Erro. Indice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras30.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Quantidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Número de indice inválido.");
        }
    }

    public static void retirarProdutoCarrinho(CarrinhoDeCompras30 carrinhoDeCompras30){
        carrinhoDeCompras30.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras30.retirarProdutoCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número de indice válido.");
        }
    }
}
