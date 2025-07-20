package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras44;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido44;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto44;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja44 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras44 carrinhoDeCompras44 = new CarrinhoDeCompras44();
    private static final Pedido44 pedido44 = new Pedido44();
    private static final List<Produto44> produtosDisponiveis = new ArrayList<>();

    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto44("Notbook",3000,200));
        produtosDisponiveis.add(new Produto44("Mouse",28,200));
        produtosDisponiveis.add(new Produto44("Teclado",340,300));

        int opcao = 0;
        do {
            exibiMenu();
            opcao = capturarOpcao();
            escolhaOpcao(opcao);
        }while (opcao != 5);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void addProdutoCarrinho(){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o índice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Erro, índice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida. Tente novamente.");
                    return;
                }
                carrinhoDeCompras44.addProdutoCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para quantidade.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro, índice inválido. Tente novamente.");
        }
    }

    private static void retirarProdutoCarrinho(){
        if (carrinhoDeCompras44.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        carrinhoDeCompras44.mostrarCarrinho();
        try {
            System.out.println("Digite o índice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= carrinhoDeCompras44.getCarrinhoDeCompras().size()){
                System.out.println("Índice inválido.");
                return;
            }
            carrinhoDeCompras44.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Índice inválido.");
        }
    }

    private static void exibiMenu(){
        System.out.println("[1] Adicionar produto no carrinho.");
        System.out.println("[2] Mostrar produto Carrinho.");
        System.out.println("[3] Retirar produto carrinho.");
        System.out.println("[4] Finalizar pedido.");
        System.out.println("[5] Sair.");
    }

    private static void escolhaOpcao(int opcao){
        switch (opcao){
            case 1:
                addProdutoCarrinho();
                break;
            case 2:
                carrinhoDeCompras44.mostrarCarrinho();
                break;
            case 3:
                retirarProdutoCarrinho();
                break;
            case 4:
                pedido44.finalizarPedido(carrinhoDeCompras44);
                break;
            case 5:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }
}
