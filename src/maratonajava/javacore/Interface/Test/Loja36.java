package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CarrinhoDeCompras36;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Pedido36;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto36;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja36 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarrinhoDeCompras36 carrinhoCompras = new CarrinhoDeCompras36();

    public static void main(String[] args) {
        List<Produto36> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto36("Notbook",2300,200));
        produtosDisponiveis.add(new Produto36("Teclado",340,300));
        produtosDisponiveis.add(new Produto36("Mouse",29,200));
        Pedido36 pedido36 = new Pedido36();
        while (true){
            System.out.println("[1] Adicionar produto no carrinho.");
            System.out.println("[2] Retirar produto do carrinho.");
            System.out.println("[3] Mostrar carrinho.");
            System.out.println("[4] Finalizar pedido.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opçõe acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        addCarrinhoProduto(produtosDisponiveis);
                        break;
                    case 2:
                        retirarProduto();
                        break;
                    case 3:
                        carrinhoCompras.exibirCarrinho();
                        break;
                    case 4:
                        pedido36.finalizarPedido(carrinhoCompras);
                        break;
                    case 5:
                        System.out.println(">>>>Finalizado pedido.");
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida. Tente novamente.");
            }
        }
    }

    public static void addCarrinhoProduto(List<Produto36> produtosDisponiveis){
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.print((i+1)+" - ");
            produtosDisponiveis.get(i).exibirInfo();
        }
        try {
            System.out.print("Digite o número do indice:");
            int produtoEscolhido = Integer.parseInt(scanner.nextLine().trim())-1;
            if (produtoEscolhido < 0 || produtoEscolhido >= produtosDisponiveis.size()){
                System.out.println("Indice inválido.");
                return;
            }
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade < 0 || quantidade > produtosDisponiveis.get(produtoEscolhido).getEstoque()){
                    System.out.println("Quantidade inválida.");
                    return;
                }
                carrinhoCompras.addCarrinho(produtosDisponiveis.get(produtoEscolhido),quantidade);
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma quantidade válida.");
            }
        }catch (NumberFormatException e){
            System.out.println("Erro. Digite um valor de indice válido.");
        }
    }

    public static void retirarProduto(){
        carrinhoCompras.exibirCarrinho();
        try {
            System.out.print("Digite o indice do produto:");
            int removerIndice = Integer.parseInt(scanner.nextLine().trim())-1;
            carrinhoCompras.retirarCarrinho(removerIndice);
        }catch (NumberFormatException e){
            System.out.println("Digite uma opção válida. Tente novamente.");
        }
    }

}
