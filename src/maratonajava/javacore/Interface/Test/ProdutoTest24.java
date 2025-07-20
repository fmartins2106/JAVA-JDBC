package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest24 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque24 estoque24 = new Estoque24();

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
            codigoOpcoes(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }


    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por nome.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    private static ProdutoPerecivel24 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate validade = Estoque24.validandoVencimento();
        return new ProdutoPerecivel24(nome,preco,quantidade,estoqueMinimo,validade);
    }

    private static ProdutosNaoPereciveis24 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque24.validandoMesesGarantia();
        String categoria = Estoque24.validandoCategoria();
        return new ProdutosNaoPereciveis24(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque24.validandoNome();
        double preco = Estoque24.validandoPreco();
        int quantidade = Estoque24.validandoQuantidade();
        int estoqueMinimo = Estoque24.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma resposta válida.");
            return;
        }
        ProdutoBase24 produtoBase24 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase24.verificarEstoqueMinimo();
        estoque24.addProdutoSistema(produtoBase24);
    }

    public static void excluirProduto(){
        String nome = Estoque24.validandoNome();
        estoque24.excluirProduto(nome);
    }

    public static void pesquisaPorNome(){
        String nome = Estoque24.validandoNome();
        estoque24.exibirPesquisaPorNome(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        if (estoque24.getProdutoBase24s().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("====Preço Mínimo====");
        double precoMinimo = Estoque24.validandoPreco();
        System.out.println("====Preço Máximo====");
        double precoMaximo = Estoque24.validandoPreco();
        estoque24.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void codigoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque24.listarProdutos();
                break;
            case 3:
                estoque24.listarProdutosVencidos();
                break;
            case 4:
                excluirProduto();
                break;
            case 5:
                pesquisaPorNome();
                break;
            case 6:
                pesquisaPorFaixaDePreco();
                break;
            case 7:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
