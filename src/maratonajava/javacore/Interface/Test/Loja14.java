package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras14;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido14;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja14 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto14> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto14("Notbook",3500,2000));
        produtosDisponiveis.add(new Produto14("Mouse",29.90,200));
        produtosDisponiveis.add(new Produto14("Teclado gamer",239, 399));
        CarrinhoDeCompras14 carrinhoDeCompras14 = new CarrinhoDeCompras14();
        Pedido14 pedido14 = new Pedido14();
        while (true){
            try {
                System.out.println("[1] Adicionar produto ao carrinho.");
                System.out.println("[2] Remover produto do carrinho.");
                System.out.println("[3] Exibir carrinho de compras.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras14);
                        break;
                    case 2:
                        retirarProdutoCarrinho(carrinhoDeCompras14);
                        break;
                    case 3:
                        carrinhoDeCompras14.exibirCarrinho();
                        break;
                    case 4:
                        pedido14.finalziarPedido(carrinhoDeCompras14);
                        break;
                    case 5:
                        System.out.println("<Finalizando programa>");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto14> produtosDisponiveis, CarrinhoDeCompras14 carrinhoDeCompras14){
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_______________________________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_______________________________________________");
        }
        try {
            System.out.print("Digite um indice de um dos produtos acima:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido. Tenta novamente.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                Produto14 estoqueDisponivel = produtosDisponiveis.get(produtoEscolhido);
                if (quantidade < 0 || quantidade > estoqueDisponivel.getEstoque()){
                    System.out.println("Quantidade indisponível.");
                    return;
                }
                carrinhoDeCompras14.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para quantidade.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void retirarProdutoCarrinho(CarrinhoDeCompras14 carrinhoDeCompras14){
        carrinhoDeCompras14.exibirCarrinho();
        try {
            System.out.print("Digite o número do indice do produto:");
            int removerIndex = Integer.parseInt(scanner.nextLine())-1;
            carrinhoDeCompras14.retirarProdutoCarrinho(removerIndex);
        }catch (NumberFormatException e){
            System.out.println("Digite um número válido.");
        }
    }


}
