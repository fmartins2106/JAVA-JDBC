package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras40;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido40;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto40;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja40 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras40 carrinhoDeCompras40 = new CarrinhoDeCompras40();
    private static final Pedido40 pedido40 = new Pedido40();
    private static final List<Produto40> produtosDisponiveis = new ArrayList<>();

    public static void main(String[] args) {
        produtosDisponiveis.add(new Produto40("Notbook",3300,300));
        produtosDisponiveis.add(new Produto40("Teclado",400, 300));
        produtosDisponiveis.add(new Produto40("Mouse",300,300));
        while (true){
            try {
                System.out.println("[1] Adiciionar produto no carrinho.");
                System.out.println("[2] Retirar produto carrinho.");
                System.out.println("[3] Mostrar carrinho.");
                System.out.println("[4] Finalizar pedido.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma opção válida:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addProdutoCarrinho();
                        break;
                    case 2:
                        retirarProdutoCarrinho();
                        break;
                    case 3:
                        carrinhoDeCompras40.mostrarCarrinho();
                        break;
                    case 4:
                        pedido40.finalizarPedido(carrinhoDeCompras40);
                        break;
                    case 5:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Erro. Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void addProdutoCarrinho(){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((1+i)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite uma número de indice:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido.");
                return;
            }
            System.out.print("Quantidade:");
            int quantidade = Integer.parseInt(scanner.nextLine().trim());
            if (quantidade < 0 || quantidade >= produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                System.out.println("Erro. Quantidade inválida.");
                return;
            }
            carrinhoDeCompras40.addProdutoCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido.");
        }
    }

    public static void retirarProdutoCarrinho(){
        if (carrinhoDeCompras40.estaVazio()){
            System.out.println("Carrinho vazio.");
            return;
        }
        carrinhoDeCompras40.mostrarCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoDeCompras40.retirarCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor válido.");
        }
    }
}
