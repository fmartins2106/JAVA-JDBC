package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras32;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido32;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto32;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja32 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CarrinhoDeCompras32 carrinhoDeCompras32 = new CarrinhoDeCompras32();
        Pedido32 pedido32 = new Pedido32();
        List<Produto32> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto32("NotBook",2300,300));
        produtosDisponiveis.add(new Produto32("Teclado",230,300));
        produtosDisponiveis.add(new Produto32("Mouse",29.39,300));
        while (true){
            System.out.println("[1] Adicionar produto ao carrinho.");
            System.out.println("[2] Retirar produto do carrinho.");
            System.out.println("[3] Mostrar carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opçõe acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras32);
                        break;
                    case 2:
                        retirarProdutoCarrinho(scanner,carrinhoDeCompras32);
                        break;
                    case 3:
                        carrinhoDeCompras32.exibirCarrinho();
                        break;
                    case 4:
                        pedido32.finalizarPedido(carrinhoDeCompras32);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto32> produtosDisponiveis, CarrinhoDeCompras32 carrinhoDeCompras32){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o número do indice:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras32.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. quantidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Indice inválido.");
        }
    }


    public static void retirarProdutoCarrinho(Scanner scanner,CarrinhoDeCompras32 carrinhoDeCompras32){
        if (carrinhoDeCompras32.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        carrinhoDeCompras32.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras32.retirarProdutoCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
