package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras34;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido34;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja34 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Produto34> produtosDisponiveis = new ArrayList<>();
    private static final CarrinhoDeCompras34 carrinhoDeCompras34 = new CarrinhoDeCompras34();
    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto34("Notbook",3400,200));
        produtosDisponiveis.add(new Produto34("Teclado",230,200));
        produtosDisponiveis.add(new Produto34("Mouse",29,300));
        Pedido34 pedido34 = new Pedido34();
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
                        addProdutoCarrinho();
                        break;
                    case 2:
                        retirarCarrinho();
                        break;
                    case 3:
                        carrinhoDeCompras34.mostrarCarrinho();
                        break;
                    case 4:
                        pedido34.finalizarPedido(carrinhoDeCompras34);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido. Tente novamente.");
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
                carrinhoDeCompras34.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido para quantidade.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número válido para o indice.");
        }
    }

    public static void retirarCarrinho(){
        if (carrinhoDeCompras34.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        carrinhoDeCompras34.mostrarCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras34.retirarCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }


}
