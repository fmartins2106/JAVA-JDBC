package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras45;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido45;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto44;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto45;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja45 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras45 carrinhoDeCompras45 = new CarrinhoDeCompras45();
    private static final List<Produto45> produtoDisponiveis = new ArrayList<>();
    private static final Pedido45 pedido45 = new Pedido45();
    public static void main(String[] args) {
        int opcao = 0;
        produtoDisponiveis.add(new Produto45("NotBook",3000,200));
        produtoDisponiveis.add(new Produto45("Teclado gamer",340,300));
        produtoDisponiveis.add(new Produto45("Mouse",34,300));
        do {
            exibirMenu();
            opcao = capturarOpcao();
            escolherOpcoes(opcao);
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void addProdutoCarrinho(){
        for (int i = 0; i < produtoDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtoDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o índice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtoDisponiveis.size()){
                System.out.println("Índice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtoDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras45.addProdutoCarrinho(produtoDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Quantidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Índice inválido.");
        }
    }

    private static void retirarProdutoCarrinho(){
        if (carrinhoDeCompras45.getCarrinhoDeCompras().isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        carrinhoDeCompras45.mostrarCarrinho();
        try {
            System.out.print("Digite o índice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice <= 0 || indice >= carrinhoDeCompras45.getCarrinhoDeCompras().size()){
                System.out.println("Índice inválido.");
                return;
            }
            carrinhoDeCompras45.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Índice inválido.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar produto no carrinho.");
        System.out.println("[2] Mostrar carrinho.");
        System.out.println("[3] Retirar produto do carrinho.");
        System.out.println("[4] Finalizar pedido.");
        System.out.println("[5] Sair.");
    }

    private static void escolherOpcoes(int opcao){
        switch (opcao){
            case 1:
                addProdutoCarrinho();
                break;
            case 2:
                carrinhoDeCompras45.mostrarCarrinho();
                break;
            case 3:
                retirarProdutoCarrinho();
                break;
            case 4:
                pedido45.finalizarPedido(carrinhoDeCompras45);
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
