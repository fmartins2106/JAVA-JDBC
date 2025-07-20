package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras15;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido15;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja15 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto15> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto15("Notbook",3500,300));
        produtosDisponiveis.add(new Produto15("Teclado gamer",230,200));
        produtosDisponiveis.add(new Produto15("Mouse",39,300));
        CarrinhoDeCompras15 carrinhoDeCompras15 = new CarrinhoDeCompras15();
        Pedido15 pedido15 = new Pedido15();
        while (true){
            try {
                System.out.println("[1] Adicionar produto ao carrinho.");
                System.out.println("[2] Remover produto carrinho.");
                System.out.println("[3] Exibir carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair do sistema.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras15);
                        break;
                    case 2:
                        removerProdutoCarrinho(carrinhoDeCompras15);
                        break;
                    case 3:
                        carrinhoDeCompras15.exibirCarrinho();
                        break;
                    case 4:
                        pedido15.finalizarPedido(carrinhoDeCompras15);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando pedido.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

   public static void addProdutoCarrinho(Scanner scanner, List<Produto15> produtosDisponiveis, CarrinhoDeCompras15 carrinhoDeCompras15){
       System.out.println("Produtos disponíveis:");
       for (int i = 0; i < produtosDisponiveis.size(); i++) {
           System.out.println("__________________________________________________________");
           System.out.print((i+1)+" - ");
           produtosDisponiveis.get(i).exibirInfo();
           System.out.println("__________________________________________________________");
       }
       try {
           System.out.print("Digite o indice do produto escolhido:");
           int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
           if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
               System.out.println("Indice não encontrado.");
               return;
           }
           try {
               System.out.print("Quantidade:");
               int quantidade = Integer.parseInt(scanner.nextLine().trim());

               if (quantidade < Produto15.MENOR_ESTOQUE || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                   System.out.println("Quantidade inválida.");
                   return;
               }
               carrinhoDeCompras15.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
           }catch (NumberFormatException e){
               System.out.println("Digite um número válido para quantidade.");
           }
       }catch (NumberFormatException e){
           System.out.println("Digite um número de indice válido.");
       }
   }

   public static void removerProdutoCarrinho(CarrinhoDeCompras15 carrinhoDeCompras15){
        carrinhoDeCompras15.exibirCarrinho();
        try {
            System.out.print("Digite o número de indice do produto que quer remover do carrinho:");
            int removerIndice = Integer.parseInt(scanner.nextLine())-1;
            carrinhoDeCompras15.retirarProdutoCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite um número de indice válido.");
        }
   }

}
