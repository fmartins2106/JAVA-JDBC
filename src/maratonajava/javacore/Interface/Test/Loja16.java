package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras16;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido16;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja16 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto16> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto16("Notbook",2999,200));
        produtosDisponiveis.add(new Produto16("Teclado Gamer",230,300));
        produtosDisponiveis.add(new Produto16("Mouse",89,200));
        CarrinhoDeCompras16 carrinhoDeCompras16 = new CarrinhoDeCompras16();
        Pedido16 pedido16 = new Pedido16();
        while (true){
           try {
               System.out.println("[1] Adicionar produto ao carrinho.");
               System.out.println("[2] Retirar produto do carrinho.");
               System.out.println("[3] Exibir carrinho.");
               System.out.println("[4] Finalizar pedido.");
               System.out.println("[5] Sair.");
               System.out.print("Digite uma das opções acima:");
               int opcao = Integer.parseInt(scanner.nextLine().trim());
               switch (opcao){
                   case 1:
                       addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras16);
                       break;
                   case 2:
                       removerProdutoCarrinho(carrinhoDeCompras16);
                       break;
                   case 3:
                       carrinhoDeCompras16.exibirCarrinho();
                       break;
                   case 4:
                       pedido16.finalizarPedido(carrinhoDeCompras16);
                       break;
                   case 5:
                       System.out.println("<Finalizando sistema>");
                       return;
                   default:
                       System.out.println("Digite uma opção válida");
               }
           }catch (NumberFormatException e){
               System.out.println("Digite uma opção válida.");
           }
        }
    }

    private static void addProdutoCarrinho(Scanner scanner, List<Produto16> produtosDisponiveis, CarrinhoDeCompras16 carrinhoDeCompras16){
        System.out.println("Lista de produtos:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("________________________________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("________________________________________________");
        }
        try {
            System.out.print("Digite o número de indice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Produto não encontrado.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < Produto16.MENOR_ESTOQUE || quantidade >= produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras16.addProdutoCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quatidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProdutoCarrinho(CarrinhoDeCompras16 carrinhoDeCompras16){
        carrinhoDeCompras16.exibirCarrinho();
        try {
            System.out.print("Digite o número do indice do produto a ser removido:");
            int removerIndice = Integer.parseInt(scanner.nextLine())-1;
            carrinhoDeCompras16.removerProdutoCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }
}
