package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras41;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido41;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto41;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja41 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Produto41> produtosDisponiveis = new ArrayList<>();
    private static final CarrinhoDeCompras41 carrinhoDeCompras41 = new CarrinhoDeCompras41();

    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto41("Notbook",2399,200));
        produtosDisponiveis.add(new Produto41("Teclado",300,100));
        produtosDisponiveis.add(new Produto41("Mouse",23,300));
        Pedido41 pedido41 = new Pedido41();
        while (true){
            System.out.println("[1] Adicionar produto no carrinho.");
            System.out.println("[2] Mostrar carrinho.");
            System.out.println("[3] Retirar produto do carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho();
                        break;
                    case 2:
                        carrinhoDeCompras41.exibirCarrinho();
                        break;
                    case 3:
                        excluirProdutoCarrinho();
                        break;
                    case 4:
                        pedido41.finalizarPedido(carrinhoDeCompras41);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= produtosDisponiveis.size()){
                System.out.println("Erro. Índice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(indice).getEstoque()){
                    System.out.println("Erro. Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras41.addCarrinho(produtosDisponiveis.get(indice),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um índice válido.");
        }
    }

    public static void excluirProdutoCarrinho(){
        carrinhoDeCompras41.exibirCarrinho();
        try {
            System.out.print("Digite o índice do produto.");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras41.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um índice válido.");
        }
    }




}
