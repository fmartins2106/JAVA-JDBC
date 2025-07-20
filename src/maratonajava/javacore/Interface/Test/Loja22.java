package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras22;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido22;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja22 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto22> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto22("Notbook",2300,300));
        produtosDisponiveis.add(new Produto22("Mouse",49,400));
        produtosDisponiveis.add(new Produto22("Teclado",230,200));
        CarrinhoDeCompras22 carrinhoDeCompras22 = new CarrinhoDeCompras22();
        Pedido22 pedido22 = new Pedido22();
        while (true){
            try {
                System.out.println("[1] Adicionar no carrinho.");
                System.out.println("[2] Retirar do carrinho.");
                System.out.println("[3] Mostrar carrinho de compras.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,carrinhoDeCompras22,produtosDisponiveis);
                        break;
                    case 2:
                        removerProdutoCarrinho(carrinhoDeCompras22);
                        break;
                    case 3:
                        carrinhoDeCompras22.exibirCarrinhoDeCompras();
                        break;
                    case 4:
                        pedido22.finalizarPedido(carrinhoDeCompras22);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(Scanner scanner, CarrinhoDeCompras22 carrinhoDeCompras22, List<Produto22> produtosDisponiveis ){
        System.out.println("escolha uma dos produtos abaixo:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("__________________________________________");
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("__________________________________________");
        }
        try {
            System.out.print("Digite um dos produtos acima:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida, verifique.");
                    return;
                }
                carrinhoDeCompras22.addProduto(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

    public static void removerProdutoCarrinho(CarrinhoDeCompras22 carrinhoDeCompras22){
        carrinhoDeCompras22.exibirCarrinhoDeCompras();
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras22.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Digite um indice válido.");
        }
    }

}
