package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras23;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido23;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja23 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto23> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto23("Notbook",3400,300));
        produtosDisponiveis.add(new Produto23("Teclado",230,200));
        produtosDisponiveis.add(new Produto23("Mouse",30,200));
        CarrinhoDeCompras23 carrinhoDeCompras23 = new CarrinhoDeCompras23();
        Pedido23 pedido23 = new Pedido23();
        while (true){
            try {
                System.out.println("[1] Adicionar produto ao carrinho.");
                System.out.println("[2] Retirar produto do carrinho.");
                System.out.println("[3] Mostrar carrinho de compras.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras23);
                        break;
                    case 2:
                        retirarProdutoCarrinho(scanner,carrinhoDeCompras23);
                        break;
                    case 3:
                        carrinhoDeCompras23.exibirCarrinhoCompras();
                        break;
                    case 4:
                        pedido23.finalizarPedido(carrinhoDeCompras23);
                        break;
                    case 5:
                        System.out.println(">>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto23> produtosDisponiveis, CarrinhoDeCompras23 carrinhoDeCompras23){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite uma das opções acima:");
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
                carrinhoDeCompras23.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void retirarProdutoCarrinho(Scanner scanner, CarrinhoDeCompras23 carrinhoDeCompras23){
        carrinhoDeCompras23.exibirCarrinhoCompras();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras23.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }


}
