package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras20;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido20;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja20 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto20> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto20("Notbook",3400,200));
        produtosDisponiveis.add(new Produto20("Mouse",30,200));
        produtosDisponiveis.add(new Produto20("Teclado",230,300));
        CarrinhoDeCompras20 carrinhoDeCompras20 = new CarrinhoDeCompras20();
        Pedido20 pedido20 = new Pedido20();
        while (true){
            try {
                System.out.println("[1] Adicionar produto ao carrinho.");
                System.out.println("[2] Remover produto do carrinho.");
                System.out.println("[3] Exibir carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,carrinhoDeCompras20,produtosDisponiveis);
                        break;
                    case 2:
                        removerProdutoCarrinho(carrinhoDeCompras20);
                        break;
                    case 3:
                        carrinhoDeCompras20.exibirCarrinho();
                        break;
                    case 4:
                        pedido20.finalizarPedido(carrinhoDeCompras20);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, CarrinhoDeCompras20 carrinhoDeCompras20, List<Produto20> produtosDisponiveis){
        System.out.println("Escolha um dos produtos abaixo:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("____________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("____________________________");
        }
        try {
            System.out.print("Digite o indice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida. Tente novamente.");
                    return;
                }
                carrinhoDeCompras20.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProdutoCarrinho(CarrinhoDeCompras20 carrinhoDeCompras20){
        carrinhoDeCompras20.exibirCarrinho();
        try {
            System.out.print("Didigite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras20.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

}
