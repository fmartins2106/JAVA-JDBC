package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras11;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido11;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto10;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja11 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto11> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto11("notbook",2300,120));
        produtosDisponiveis.add(new Produto11("teclado",230,100));
        produtosDisponiveis.add(new Produto11("mouse",40,200));
        CarrinhoDeCompras11 carrinhoDeCompras11 = new CarrinhoDeCompras11();
        Pedido11 pedido11 = new Pedido11();
        while (true){
            System.out.println("[1] Adicionar produto no carrinho.");
            System.out.println("[2] Remover produto carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addCarinho(scanner,produtosDisponiveis,carrinhoDeCompras11);
                        break;
                    case 2:
                        removerProduto(scanner,carrinhoDeCompras11);
                        break;
                    case 3:
                        carrinhoDeCompras11.mostrarCarrinho();
                        break;
                    case 4:
                        pedido11.finalizarPedido(carrinhoDeCompras11);
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

    public static void addCarinho(Scanner scanner, List<Produto11> produtosDisponiveis, CarrinhoDeCompras11 carrinhoDeCompras11){
        System.out.println("Produto disponíveis.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_______________________________________________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_______________________________________________________________");
        }
        try {
            System.out.print("Escolha um produto:");
            int produtoescolhido = Integer.parseInt(scanner.nextLine())-1;
            if (produtoescolhido < 0 || produtoescolhido >= produtosDisponiveis.size()){
                System.out.println("Produto não encontrado");
                return;
            }
            try {
              System.out.print("Quantidade:");
              int quantidade = Integer.parseInt(scanner.nextLine());
              Produto11 produtoSelecionado = produtosDisponiveis.get(produtoescolhido);
              if (quantidade < Produto11.MENOR_ESTOQUE || quantidade >= produtoSelecionado.getEstoque()){
                  System.out.println("Quantidade inválida.");
              }
              carrinhoDeCompras11.addCarrinho(produtosDisponiveis.get(produtoescolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProduto(Scanner scanner, CarrinhoDeCompras11 carrinhoDeCompras11){
        carrinhoDeCompras11.mostrarCarrinho();
        try {
            System.out.print("Digite o produto a ser retirado:");
            int removerIndex = Integer.parseInt(scanner.nextLine())-1;
            if (removerIndex <= 0 || removerIndex >= carrinhoDeCompras11.tamanhoCarrinho()){
                System.out.println("Produto não encontrado.");
                return;
            }
            carrinhoDeCompras11.retirarCarrinho(removerIndex);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }
}
