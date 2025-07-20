package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras18;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido18;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto18;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja18 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Produto18> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto18("Notbook",3400,100));
        produtosDisponiveis.add(new Produto18("Teclado",230,100));
        produtosDisponiveis.add(new Produto18("Mouse",33,100));
        CarrinhoDeCompras18 carrinhoDeCompras18 = new CarrinhoDeCompras18();
        Pedido18 pedido18 = new Pedido18();
        while (true){
            System.out.println("[1] Adicionar produto ao carrinho.");
            System.out.println("[2] Remover produto do carrinho.");
            System.out.println("[3] Exibir carrinho de compras.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao  = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras18);
                        break;
                    case 2:
                        removerProduto(carrinhoDeCompras18);
                        break;
                    case 3:
                        carrinhoDeCompras18.exibirCarrinho();
                        break;
                    case 4:
                        pedido18.finalizarPedido(carrinhoDeCompras18);
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

    public static void addProdutoCarrinho(Scanner scanner, List<Produto18> produtosDisponiveis, CarrinhoDeCompras18 carrinhoDeCompras18){
        System.out.println("Lista de produtos:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido, verifique.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < Produto18.MENOR_ESTOQUE || quantidade >= produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida, verifique.");
                    return;
                }
                carrinhoDeCompras18.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProduto(CarrinhoDeCompras18 carrinhoDeCompras18){
        carrinhoDeCompras18.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto a ser removido:");
            int removerIndex = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras18.retirarCarrinho(removerIndex);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }



}
