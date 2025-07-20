package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras43;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido43;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto43;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja43 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras43 carrinhoDeCompras43 = new CarrinhoDeCompras43();
    private static final Pedido43 pedido43 = new Pedido43();
    private static final List<Produto43> produtosDiposniveis = new ArrayList<>();

    public static void main(String[] args) {
        produtosDiposniveis.add(new Produto43("Notbook",2300,200));
        produtosDiposniveis.add(new Produto43("Teclado",200,200));
        produtosDiposniveis.add(new Produto43("Mouse",2300,300));
        int opcao = 0;
        do {
            exibirInfo();
            opcao = capturarOpcao();
            processarOpcao(opcao);
        }while (opcao != 5);
        System.out.println(">>>Finalizando sistema");
    }

    private static void removerProdutoCarrinho(){
        if (carrinhoDeCompras43.getCarrinhoDeCompras().isEmpty()){
            System.out.println("Carrinho vazio.");
            return;
        }
        carrinhoDeCompras43.mostrarCarrinho();
        try {
            System.out.println("Digite o índice do produto:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice>= carrinhoDeCompras43.getCarrinhoDeCompras().size()){
                System.out.println("Índice inválido.");
                return;
            }
            carrinhoDeCompras43.retirarProdutoCarrinho(indice);
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    private static void addProdutoCarrinho(){
        for (int i = 0; i < produtosDiposniveis.size(); i++) {
            System.out.println("_______________________________________________");
            System.out.print((1+i)+" - ");
            produtosDiposniveis.get(i).exibirInfo();
            System.out.println("_______________________________________________");
        }
        try {
            System.out.print("Digite o índice do evento:");
            int indice = Integer.parseInt(scanner.nextLine().trim())-1;
            if (indice < 0 || indice >= produtosDiposniveis.size()){
                System.out.println("Índice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDiposniveis.get(indice).getQuantidade()){
                    System.out.println("Erro. Quantidade inválida. Verifique.");
                    return;
                }
                carrinhoDeCompras43.addProdutoCarrinho(produtosDiposniveis.get(indice),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Quantidade inválida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Índice inválido.");
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void processarOpcao(int opcao){
        switch (opcao){
            case 1:
                addProdutoCarrinho();
                break;
            case 2:
                carrinhoDeCompras43.mostrarCarrinho();
                break;
            case 3:
                removerProdutoCarrinho();
                break;
            case 4:
                pedido43.finalizarPedido(carrinhoDeCompras43);
                break;
            case 5:
                break;
            default:
                System.out.println("Erro. Opção inválida.");
        }
    }

    private static void exibirInfo(){
        System.out.println("[1] Adicionar produto no carrinho.");
        System.out.println("[2] Mostrar carrinho.");
        System.out.println("[3] Retirar produto do carrinho.");
        System.out.println("[4] Finalizar pedido.");
        System.out.println("[5] Sair.");
    }
}
