package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras13;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido13;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja13 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto13> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto13("Notbook",3400,400));
        produtosDisponiveis.add(new Produto13("Mouse",29.90,90));
        produtosDisponiveis.add(new Produto13("Teclado gamer",230,100));
        CarrinhoDeCompras13 carrinhoDeCompras13 = new CarrinhoDeCompras13();
        Pedido13 pedido13 = new Pedido13();
        while (true){
            System.out.println("[1] Adicionar produto carrinho.");
            System.out.println("[2] Retirar produto carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,carrinhoDeCompras13,produtosDisponiveis);
                        break;
                    case 2:
                        removerProdutoCarrinho(carrinhoDeCompras13);
                        break;
                    case 3:
                        carrinhoDeCompras13.mostrarCarrinho();
                        break;
                    case 4:
                        pedido13.finalizarPedido(carrinhoDeCompras13);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner,CarrinhoDeCompras13 carrinhoDeCompras13,List<Produto13> produtosDisponiveis){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o número do indice de um dos produtos acima:");
            int opcao = Integer.parseInt(scanner.nextLine())-1;
            if (opcao < 0 || opcao >= produtosDisponiveis.size()){
                System.out.println("Produto não encontrado. Digite um indice válido.");
                return;
            }
            try {
                System.out.print("Digite a quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < Produto13.MENOR_ESTOQUE || quantidade > produtosDisponiveis.size()){
                    System.out.println("Quantidade inválida. Tente novamente.");
                    return;
                }
                carrinhoDeCompras13.addProdutoCarrinho(produtosDisponiveis.get(opcao),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite uma quantidade válida.");
        }
    }

    public static void removerProdutoCarrinho(CarrinhoDeCompras13 carrinhoDeCompras13){
        carrinhoDeCompras13.mostrarCarrinho();
        try {
            System.out.print("Digite o indice do produto a ser retirado:");
            int removerIndice = Integer.parseInt(scanner.nextLine())-1;

            carrinhoDeCompras13.retirarProdutoCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

}
