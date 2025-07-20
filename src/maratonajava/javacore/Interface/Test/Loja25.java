package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras25;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido25;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto25;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja25 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto25> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto25("Notbook",2300,300));
        produtosDisponiveis.add(new Produto25("Teclado",230,300));
        produtosDisponiveis.add(new Produto25("Mouse",35,300));
        CarrinhoDeCompras25 carrinhoDeCompras25 = new CarrinhoDeCompras25();
        Pedido25 pedido25 = new Pedido25();
        while (true){
            try {
                System.out.println("[1] Adicionar produto no carrinho.");
                System.out.println("[2] Remover produto do carrinho.");
                System.out.println("[3] Mostrar carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras25);
                        break;
                    case 2:
                        removerProdutoCarrinho(carrinhoDeCompras25);
                        break;
                    case 3:
                        carrinhoDeCompras25.exibirCarrinho();
                        break;
                    case 4:
                        pedido25.finalizarPedido(carrinhoDeCompras25);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto25> produtosDisponiveis, CarrinhoDeCompras25 carrinhoDeCompras25){
        System.out.println("Lista de produtos.");
        for (int i = 0; i < produtosDisponiveis.size() ; i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= produtosDisponiveis.size()){
                System.out.println("Digite um indice válido.");
                return;
            }
            try {
                System.out.print("Digite a quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(indice).getEstoque()){
                    System.out.println("Indice inválido.");
                    return;
                }
                carrinhoDeCompras25.addCarrinho(produtosDisponiveis.get(indice),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite um indice válido.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProdutoCarrinho(CarrinhoDeCompras25 carrinhoDeCompras25){
        carrinhoDeCompras25.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras25.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }
}
