package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras17;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido17;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja17 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto17> produtosDiponiveis = new ArrayList<>();
        produtosDiponiveis.add(new Produto17("Notbook",3233,100));
        produtosDiponiveis.add(new Produto17("Teclado",100,200));
        produtosDiponiveis.add(new Produto17("Mouse",50,300));
        CarrinhoDeCompras17 carrinhoDeCompras17 = new CarrinhoDeCompras17();
        Pedido17 pedido17 = new Pedido17();
        while (true){
            System.out.println("[1] Adicionar produto ao carrinho.");
            System.out.println("[2] Remover produto carrinho.");
            System.out.println("[3] Exibir carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDiponiveis,carrinhoDeCompras17);
                        break;
                    case 2:
                        retirarProdutoCarrinho(carrinhoDeCompras17);
                        break;
                    case 3:
                        carrinhoDeCompras17.exibirCarrinho();
                        break;
                    case 4:
                        pedido17.finalizarPedido(carrinhoDeCompras17);
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

    public static void addProdutoCarrinho(Scanner scanner, List<Produto17> produtosDisponiveis, CarrinhoDeCompras17 carrinhoDeCompras17){
        System.out.println("Lista de produtos:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice do produto:");
            int produtoEscolhido =  Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < Produto17.MENOR_ESTOQUE || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Operação negada. Verifique quantidade.");
                    return;
                }
                carrinhoDeCompras17.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }

    public static void retirarProdutoCarrinho(CarrinhoDeCompras17 carrinhoDeCompras17){
        carrinhoDeCompras17.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras17.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }
}
