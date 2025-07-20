package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras37;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido37;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto37;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja37 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras37 carrinhoDeCompras37 = new CarrinhoDeCompras37();
    private static final List<Produto37> produtosDisponiveis = new ArrayList<>();

    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto37("Notbook",2300,300));
        produtosDisponiveis.add(new Produto37("Teclado",230, 300));
        produtosDisponiveis.add(new Produto37("Mouse",30,300));
        while (true){
            Pedido37 pedido37 = new Pedido37();
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
                        addProdutoCarrinho();
                        break;
                    case 2:
                        retirarProdutoCarrinho();
                        break;
                    case 3:
                        carrinhoDeCompras37.exibiCarrinho();
                        break;
                    case 4:
                        pedido37.finalizarPedido(carrinhoDeCompras37);
                        break;
                    case 5:
                        System.out.println(">>>Finaliando pedido.");
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
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
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
                    System.out.println("Erro. Valor inválido.");
                    return;
                }
                carrinhoDeCompras37.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Quantidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Número de indice inválido.");
        }
    }

    public static void retirarProdutoCarrinho(){
        carrinhoDeCompras37.exibiCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras37.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido.");
        }
    }

}
