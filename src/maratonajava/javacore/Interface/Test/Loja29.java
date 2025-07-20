package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras29;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido29;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto29;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja29 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto29> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto29("NotBook",2300, 200));
        produtosDisponiveis.add(new Produto29("Teclado",200,300));
        produtosDisponiveis.add(new Produto29("Mouse",39,300));
        CarrinhoDeCompras29 carrinhoDeCompras29 = new CarrinhoDeCompras29();
        Pedido29 pedido29 = new Pedido29();
        while (true){
            System.out.println("[1] Adicionar produto no carrinho.");
            System.out.println("[2] Retirar produto do carrinho.");
            System.out.println("[3] Mostrar carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras29);
                        break;
                    case 2:
                        retirarProdutoCarrinho(carrinhoDeCompras29);
                        break;
                    case 3:
                        carrinhoDeCompras29.exibirCarrinho();
                        break;
                    case 4:
                        pedido29.finalizarPedido(carrinhoDeCompras29);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, List<Produto29> produtosDisponiveis, CarrinhoDeCompras29 carrinhoDeCompras29){
        System.out.println("Produtos disponíveis.");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_________________________________________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_________________________________________________________");
        }
        try {
            System.out.print("Digite o número do indice:");
            int numeroIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (numeroIndice < 0 || numeroIndice >= produtosDisponiveis.size()){
                System.out.println("Erro. Digite um número de indice válido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(numeroIndice).getEstoque()){
                    System.out.println("Operação negada. Quantiade inválida.");
                    return;
                }
                carrinhoDeCompras29.addProdutoCarrinho(produtosDisponiveis.get(numeroIndice),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para quantidade.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um número válido de indice.");
        }
    }

    public static void retirarProdutoCarrinho(CarrinhoDeCompras29 carrinhoDeCompras29){
        carrinhoDeCompras29.exibirCarrinho();
        try {
            System.out.print("Digite o indiceo do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras29.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Digite um número válido para indice.");
        }
    }

}
