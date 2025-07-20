package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest21 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque21 estoque21 = new Estoque21();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
            codigoFinalOpcao(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Pesquisa por nome.");
        System.out.println("[7] Sair.");
    }

    private static ProdutoPerecivel21 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque21.validandoDataValidade();
        return new ProdutoPerecivel21(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis21 criarProdutoNaoPerecivel(String nome, double preco, int quatidade, int estoqueminimo){
        int mesesGarantia = Estoque21.validandoMesesGarantia();
        String categoria = Estoque21.validandoCategoria();
        return new ProdutosNaoPereciveis21(nome,preco,quatidade,estoqueminimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque21.validandoNome();
        double preco = Estoque21.validandoPreco();
        int quantidade = Estoque21.validandoQuantidade();
        int estoqueMinimo = Estoque21.validandoEstoqueMinimo();
        String tipoProduto = "";
        do {
            System.out.print("Produto é perecivél?(sim|não):");
            tipoProduto = scanner.nextLine().trim();
            if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")) {
                System.out.println("Digite apenas sim ou não.");
            }
        }while (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não"));
        ProdutoBase21 produtos21 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtos21.verificarEstoqueMinimo();
        estoque21.addProdutoSistema(produtos21);
    }

    public static void excluirDados(){
        String nome = Estoque21.validandoNome();
        estoque21.excluirDadosProduto(nome);
    }

    public static void pesquisaPorNome(){
        String nome = Estoque21.validandoNome();
        estoque21.exibirPesquisaPorNome(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        if (estoque21.getProdutoBase21s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque21.validandoPreco();
        double precoMaximo = Estoque21.validandoPreco();
        estoque21.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    private static void codigoFinalOpcao(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque21.listarProdutosCadastrados();
                break;
            case 3:
                estoque21.listarProdutosVencidos();
                break;
            case 4:
                excluirDados();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
            case 6:
                pesquisaPorNome();
                break;
            case 7:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
