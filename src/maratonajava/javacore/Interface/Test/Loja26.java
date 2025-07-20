package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras26;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido26;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja26 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto26> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto26("Notbook",3400,200));
        produtosDisponiveis.add(new Produto26("Teclado",230,300));
        produtosDisponiveis.add(new Produto26("Mouse",23,300));
        CarrinhoDeCompras26 carrinhoDeCompras26 = new CarrinhoDeCompras26();
        Pedido26 pedido26 = new Pedido26();
        while (true){
            try {
                System.out.println("[1] Adicionar produto carrinho.");
                System.out.println("[2] Retirar produto carrinho.");
                System.out.println("[3] Exibir carrinho.");
                System.out.println("[4] Finalizar pedodo.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutosCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras26);
                        break;
                    case 2:
                        removerProdutoCarrinho(carrinhoDeCompras26);
                        break;
                    case 3:
                        carrinhoDeCompras26.exibirCarrinho();
                        break;
                    case 4:
                        pedido26.finalizarPedido(carrinhoDeCompras26);
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

    public static void addProdutosCarrinho(Scanner scanner, List<Produto26> produtosDisponiveis, CarrinhoDeCompras26 carrinhoDeCompras26){
        System.out.println("Lista de produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_________________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_________________________________");
        }
        try {
            System.out.print("Digite o indice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice não encontrado.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras26.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProdutoCarrinho(CarrinhoDeCompras26 carrinhoDeCompras26){
        carrinhoDeCompras26.exibirCarrinho();
        try {
            System.out.print("Digite um indice:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras26.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }
}
