package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest10 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque10 estoque = new Estoque10();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            exibirOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Listar produtos.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel10 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque10.validandoDataValidade();

        return new ProdutoPerecivel10(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis10 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque10.valindandoMesesGarantia();
        String categoria = Estoque10.validandoCategoria();

        return new ProdutosNaoPereciveis10(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque10.validandoNome();
        double preco = Estoque10.validandoPreco();
        int quantidade = Estoque10.validandoQuantidade();
        int estoqueMinimo = Estoque10.validandoEstoqueMinimo();

        System.out.print("Produto é perecivél?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Opção inválida. Tente novamente.");
            return;
        }
        Produtobase10 produtobase10 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);

        produtobase10.verificarEstoqueMinimo();
        estoque.addProdutoSistema(produtobase10);
    }

    private static void retirarProduto(){
        String nome = Estoque10.validandoNome();
        estoque.excluirProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        double precoMinimo = Estoque10.validandoPreco();
        double precoMaximo = Estoque10.validandoPreco();
        estoque.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    private static void exibirOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque.listarProdutosCadastrados();
                break;
            case 3:
                estoque.listarProdutosVencidos();
                break;
            case 4:
                retirarProduto();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
