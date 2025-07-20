package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras38;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido38;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto38;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja38 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Produto38> produtosDisponiveis =  new ArrayList<>();
    private static final Pedido38 pedido38 = new Pedido38();
    private static final CarrinhoDeCompras38 carrinhoDeCompras38 = new CarrinhoDeCompras38();
    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto38("Notbook",3400,300));
        produtosDisponiveis.add(new Produto38("Mouse",30,400));
        produtosDisponiveis.add(new Produto38("Teclado",340,200));
        while (true){
            try {
                System.out.println("[1] Adicionar produto no carrinho.");
                System.out.println("[2] ExibirCarrinho.");
                System.out.println("[3] Retirar produto carrino.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho();
                        break;
                    case 2:
                        carrinhoDeCompras38.exibirCarrinho();
                        break;
                    case 3:
                        retirarProdutoCarrinho();
                        break;
                    case 4:
                        pedido38.finalizarPedido(carrinhoDeCompras38);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma número válido.");
            }
        }
    }

    public static void addProdutoCarrinho(){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite uma das opções acima:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Erro. Quantidade indisponível.");
                    return;
                }
                carrinhoDeCompras38.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Quantidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Indice inválido.");
        }
    }

    public static void retirarProdutoCarrinho(){
        carrinhoDeCompras38.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras38.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número válido.");
        }
    }
}
