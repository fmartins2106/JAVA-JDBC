package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras27;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido27;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja27 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto27> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto27("Notbook",3400,200));
        produtosDisponiveis.add(new Produto27("Teclado",230,300));
        produtosDisponiveis.add(new Produto27("Mouse",29,300));
        CarrinhoDeCompras27 carrinhoDeCompras27 = new CarrinhoDeCompras27();
        Pedido27 pedido27 = new Pedido27();
        while (true){
            try {
                System.out.println("[1] Adicionar o produto no carrinho.");
                System.out.println("[2] Mostrar produtos no carrinho.");
                System.out.println("[3] Retirar produto do carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opçõe acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,carrinhoDeCompras27,produtosDisponiveis);
                        break;
                    case 2:
                        carrinhoDeCompras27.exibirCarrinhoDeCompras();
                        break;
                    case 3:
                        removerProdutoCarrinho(carrinhoDeCompras27);
                        break;
                    case 4:
                        pedido27.finalizarPedido(carrinhoDeCompras27);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, CarrinhoDeCompras27 carrinhoDeCompras27, List<Produto27> produtosDisponiveis){
        System.out.println("Lista de produtos.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_________________________________________________________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_________________________________________________________________________");
        }
        try {
            System.out.print("Digite o indice do produto:");
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
                carrinhoDeCompras27.addProdutoCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número de indice válido.");
        }
    }

    public static void removerProdutoCarrinho(CarrinhoDeCompras27 carrinhoDeCompras27){
        carrinhoDeCompras27.exibirCarrinhoDeCompras();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras27.retirarProdutoCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }
}
