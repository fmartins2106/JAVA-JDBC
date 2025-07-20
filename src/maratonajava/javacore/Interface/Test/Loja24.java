package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras24;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido24;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja24 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto24> produtosDiponiveis = new ArrayList<>();
        produtosDiponiveis.add(new Produto24("Notbook",2330,300));
        produtosDiponiveis.add(new Produto24("Teclado",334,200));
        produtosDiponiveis.add(new Produto24("Mouse",39,300));
        CarrinhoDeCompras24 carrinhoDeCompras24 = new CarrinhoDeCompras24();
        Pedido24 pedido24 = new Pedido24();
        while (true){
            System.out.println("[1] Adicionar produto no carrinho.");
            System.out.println("[2] Retirar produto do carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,carrinhoDeCompras24,produtosDiponiveis);
                        break;
                    case 2:
                        retirarProdutoCarrinho(carrinhoDeCompras24);
                        break;
                    case 3:
                        carrinhoDeCompras24.mostrarCarrinho();
                        break;
                    case 4:
                        pedido24.finalizarPedido(carrinhoDeCompras24);
                        break;
                    case 5:
                        System.out.println(">>>Finalizar pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, CarrinhoDeCompras24 carrinhoDeCompras24, List<Produto24> produtosDisponiveis){
        System.out.println("Produtos disponíveis.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= produtosDisponiveis.size()){
                System.out.println("Indice não encontrado.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(indice).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras24.addProdutoCarrinho(produtosDisponiveis.get(indice),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public static void retirarProdutoCarrinho(CarrinhoDeCompras24 carrinhoDeCompras24){
        carrinhoDeCompras24.mostrarCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras24.retirarProdutoCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }


}
