package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras21;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido21;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja21 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto21> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto21("Notbook",3000,200));
        produtosDisponiveis.add(new Produto21("Teclado",230,100));
        produtosDisponiveis.add(new Produto21("Mouse",23,100));
        CarrinhoDeCompras21 carrinhoDeCompras21 = new CarrinhoDeCompras21();
        Pedido21 pedido21 = new Pedido21();

        while (true){
            try {
                System.out.println("[1] Adicionar produto ao carrinho.");
                System.out.println("[2] Remover produto do carrinho.");
                System.out.println("[3] Mostrar carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,carrinhoDeCompras21,produtosDisponiveis);
                        break;
                    case 2:
                        retirarProdutoCarrinho(carrinhoDeCompras21);
                        break;
                    case 3:
                        carrinhoDeCompras21.mostrarCarrinho();
                        break;
                    case 4:
                        pedido21.finalizarPedido(carrinhoDeCompras21);
                        break;
                    case 5:
                        System.out.println(">>>Finalizar pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, CarrinhoDeCompras21 carrinhoDeCompras21, List<Produto21> produtosDisponiveis){
        System.out.println("Escolha uma dos produtos abaixo.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o número do indice:");
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
                carrinhoDeCompras21.addProdutos(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void retirarProdutoCarrinho(CarrinhoDeCompras21 carrinhoDeCompras21){
        carrinhoDeCompras21.mostrarCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int indexRetirar = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras21.retirarProdutoCarrinho(indexRetirar);
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

}
