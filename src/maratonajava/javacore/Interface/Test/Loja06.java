package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras06;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido06;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto06> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto06("Notbook",3500,300));
        produtosDisponiveis.add(new Produto06("Mouse",39,399));
        produtosDisponiveis.add(new Produto06("Teclado",399,3999));
        CarrinhoDeCompras06 carrinhoDeCompras06 = new CarrinhoDeCompras06();
        Pedido06 pedido06 = new Pedido06();

        while (true){
            System.out.println("[1] Adicionar ao carrinho.");
            System.out.println("[2] Remover produto do carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutosCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras06);
                        break;
                    case 2:
                        removerProdutoCarrinho(scanner,carrinhoDeCompras06);
                        break;
                    case 3:
                        carrinhoDeCompras06.exibirCarrinho();
                        break;
                    case 4:
                        pedido06.finalizarPedido(carrinhoDeCompras06);
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

    public static void addProdutosCarrinho(Scanner scanner, List<Produto06> produtosDisponiveis, CarrinhoDeCompras06 carrinhoDeCompras06){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_______________________");
            System.out.println((i+1)+" x ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_______________________");
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
                if (quantidade <= 0){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras06.addProdutoCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para definir quantidade.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um produto válido.");
        }
    }

    public static void removerProdutoCarrinho(Scanner scanner, CarrinhoDeCompras06 carrinhoDeCompras06){
        carrinhoDeCompras06.exibirCarrinho();
        try {
            System.out.println("Digite um indice do produto para remover:");
            int removerIndex = Integer.parseInt(scanner.nextLine())-1;
            if (removerIndex < 0 || removerIndex >= carrinhoDeCompras06.tamanhoCarrinho()){
                System.out.println("Digite um número válido.");
                return;
            }
            carrinhoDeCompras06.removerProdutoCarrinho(removerIndex);
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }
}
