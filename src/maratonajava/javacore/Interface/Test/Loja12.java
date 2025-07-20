package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras12;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido12;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja12 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto12> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto12("Notbook",3500,200));
        produtosDisponiveis.add(new Produto12("Mouse",29,388));
        produtosDisponiveis.add(new Produto12("teclado gamer",230,320));
        CarrinhoDeCompras12 carrinhoDeCompras12 = new CarrinhoDeCompras12();
        Pedido12 pedido12 = new Pedido12();
        while (true){
            System.out.println("[1] Adicionar produto ao carrinho.");
            System.out.println("[2] Excluir produto do carrinho.");
            System.out.println("[3] Mostrar carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho(scanner,produtosDisponiveis,carrinhoDeCompras12);
                        break;
                    case 2:
                        retirarCarrinho(carrinhoDeCompras12);
                        break;
                    case 3:
                        carrinhoDeCompras12.exibirCarrinho();
                        break;
                    case 4:
                        pedido12.finalizarPedido(carrinhoDeCompras12);
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

    private static void addProdutoCarrinho(Scanner scanner, List<Produto12> produtosDisponiveis, CarrinhoDeCompras12 carrinhoDeCompras12){
        System.out.println("Lista de produtos:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println("_________________________________________");
            System.out.print((i+1));
            produtosDisponiveis.get(i).exibirInfo();
            System.out.println("_________________________________________");
        }
        try {
            System.out.print("Digite o indice do produto para adicionar ao carrinho:");
            int produto = Integer.parseInt(scanner.nextLine())-1;
            if (produto < 0 || produto >= produtosDisponiveis.size()){
                System.out.println("Indice não encontrado.");
                return;
            }
            try {
                System.out.print("Digite a quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                for (Produto12 produtosDisponivei : produtosDisponiveis) {
                    if (quantidade <= Produto12.MENOR_ESTOQUE || quantidade > produtosDisponivei.getEstoque()) {
                        System.out.println("Quantidade inválida.");
                        return;
                    }
                }
                carrinhoDeCompras12.addProdutoCarrinho(produtosDisponiveis.get(produto),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número de indice válido.");
        }
    }

    public static void retirarCarrinho(CarrinhoDeCompras12 carrinhoDeCompras12){
        carrinhoDeCompras12.exibirCarrinho();
        try {
            System.out.print("Digite o número de indice do produto:");
            int removerProduto = Integer.parseInt(scanner.nextLine())-1;
            if (removerProduto < 0 || removerProduto >= carrinhoDeCompras12.tamanhoCarrinho()){
                System.out.println("Indice não encontrado. Tente novamente.");
                return;
            }
            carrinhoDeCompras12.retirarProdutoCarrinho(removerProduto);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida.");
        }
    }

}

