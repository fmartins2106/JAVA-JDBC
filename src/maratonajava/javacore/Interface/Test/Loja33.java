package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras33;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido33;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto33;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto33> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto33("Notbook",3499,400));
        produtosDisponiveis.add(new Produto33("Teclado",340,400));
        produtosDisponiveis.add(new Produto33("Mouse",44,300));
        CarrinhoDeCompras33 carrinhoDeCompras33 = new CarrinhoDeCompras33();
        Pedido33 pedido33 = new Pedido33();
        while (true){
            System.out.println("[1] Adicionar produto ao carrinho.");
            System.out.println("[2] Retirar produto carrinho.");
            System.out.println("[3] Mostrar carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        adicionarProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras33);
                        break;
                    case 2:
                        retirarProdutoCarrinho(scanner,carrinhoDeCompras33);
                        break;
                    case 3:
                        carrinhoDeCompras33.mostrarCarrinho();
                        break;
                    case 4:
                        pedido33.finalizarPedido(carrinhoDeCompras33);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void adicionarProdutoCarrinho(Scanner scanner, List<Produto33> produtosDisponiveis, CarrinhoDeCompras33 carrinhoDeCompras33){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o indice:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= produtosDisponiveis.size()){
                System.out.println("Indice inválido. Tente novamente.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(indice).getEstoque()){
                    System.out.println("Quantidade inválida. Tente novamente.");
                    return;
                }
                carrinhoDeCompras33.addProduto(produtosDisponiveis.get(indice),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Quantidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Indice inválido.");
        }
    }

    public static void retirarProdutoCarrinho(Scanner scanner,CarrinhoDeCompras33 carrinhoDeCompras33){
        if (carrinhoDeCompras33.getProdutoCarrinho().isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        carrinhoDeCompras33.mostrarCarrinho();
        try {
            System.out.print("Digite o número do indice:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras33.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite um número de indice válido.");
        }
    }



}
