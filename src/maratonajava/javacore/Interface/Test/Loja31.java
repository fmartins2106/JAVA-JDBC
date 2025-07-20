package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras31;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido31;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto31;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja31 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto31> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto31("NotBook",2300,300));
        produtosDisponiveis.add(new Produto31("Teclado",230,200));
        produtosDisponiveis.add(new Produto31("Mouse",23,200));
        CarrinhoDeCompras31 carrinhoDeCompras31 = new CarrinhoDeCompras31();
        Pedido31 pedido31 = new Pedido31();
        while (true){
            try {
                System.out.println("[1] Adicionar produto no carrinho.");
                System.out.println("[2] Retirar produto do carrinho.");
                System.out.println("[3] Mostrar carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        adicionarProdutoCarrinho(carrinhoDeCompras31,produtosDisponiveis,scanner);
                        break;
                    case 2:
                        retirarCarrinho(carrinhoDeCompras31);
                        break;
                    case 3:
                        carrinhoDeCompras31.exibirCarrinho();
                        break;
                    case 4:
                        pedido31.finalizarPedido(carrinhoDeCompras31);
                    case 5:
                        System.out.println(">>>Finalizando o pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void adicionarProdutoCarrinho(CarrinhoDeCompras31 carrinhoDeCompras31, List<Produto31> produtosDisponiveis, Scanner scanner){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
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
                carrinhoDeCompras31.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite a quantidade.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um indice válido.");
        }
    }

    public static void retirarCarrinho(CarrinhoDeCompras31 carrinhoDeCompras31){
        carrinhoDeCompras31.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim());
            carrinhoDeCompras31.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido.");
        }
    }

}
