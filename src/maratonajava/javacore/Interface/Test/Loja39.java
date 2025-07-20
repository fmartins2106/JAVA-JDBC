package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras39;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido39;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto39;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja39 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras39 carrinhoDeCompras = new CarrinhoDeCompras39();
    private static final List<Produto39> produtosDisponiveis = new ArrayList<>();
    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto39("NootBook",2300,300));
        produtosDisponiveis.add(new Produto39("Teclado",340,300));
        produtosDisponiveis.add(new Produto39("Mouse",20,300));
        Pedido39 pedido39 = new Pedido39();
        while (true){
            System.out.println("[1] Adicionar produto no carrinho.");
            System.out.println("[2] Mostrar carrinho.");
            System.out.println("[3] Retirar produto carrinho.");
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
                        carrinhoDeCompras.mostrarCarrinhoDeCompras();
                        break;
                    case 3:
                        retirarProdutoCarrinho();
                        break;
                    case 4:
                        pedido39.finalizarPedido(carrinhoDeCompras);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Erro. Valor inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice do produto:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Erro. Indice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Erro. Quantidade inválida.");
                    return;
                }
                carrinhoDeCompras.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número de indice válido.");
        }
    }

    public static void retirarProdutoCarrinho(){
        carrinhoDeCompras.mostrarCarrinhoDeCompras();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim());
            carrinhoDeCompras.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
