package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque14;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase14;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel14;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis14;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest14 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque14 estoque14 = new Estoque14();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            opcoesMenu(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro de produto.");
        System.out.println("[2] Listar produtos cadastrados.");
        System.out.println("[3] Excluir produto.");
        System.out.println("[4] Listar produtos vencidos.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel14 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque14.validandoDataValidade();

        return new ProdutoPerecivel14(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis14 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque14.validandoMesesGarantia();
        String categoria = Estoque14.validandoCategoria();

        return new ProdutosNaoPereciveis14(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque14.validacaoNome();
        double preco = Estoque14.validacaoPreco();
        int quantidade = Estoque14.validandoQuantidade();
        int estoqueMinimo = Estoque14.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma opção válida.");
            return;
        }
        ProdutoBase14 produtoBase14 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase14.verificarEstoqueMinimo();
        estoque14.addProdutosSistema(produtoBase14);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque14.getProdutoBase14s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque14.validacaoPreco();
        double precoMaximo = Estoque14.validacaoPreco();
        estoque14.listarProdutosPorFaixaDePreco(precoMinimo, precoMaximo);
    }

    private static void excluirDadosProduto(){
        String nome = Estoque14.validacaoNome();
        estoque14.excluirDadosPesquisa(nome);
    }

    private static void opcoesMenu(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque14.listarProdutosCadastrados();
                break;
            case 3:
                excluirDadosProduto();
                break;
            case 4:
                estoque14.listarProdutosVencidos();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
