package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest31 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque31 estoque31 = new Estoque31();
    private static final RelatorioEstoque31 relatorioEstoque31 = new RelatorioEstoque31();
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
            metodoOpcoes(opcao);
        }while (opcao != 8);
        System.out.println(">>>Finalizando sistema.");
    }
    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProdutoSistema();
                break;
            case 2:
                estoque31.listarProdutosCadastrados();
                break;
            case 3:
                estoque31.listarProdutoVencidos();
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
                relatorioEstoque31.gerarRelatorio(estoque31.getProdutoBase31s());
                break;
            case 8:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
    private static void exibirMenu(){
        System.out.println("[1] Cadastro de produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto sistema.");
        System.out.println("[5] Pesquisa por nome.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Exportar relatório.");
        System.out.println("[8] Sair.");
    }

    private static ProdutoPerecivel31 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque31.validandoDataValidade();
        return new ProdutoPerecivel31(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis31 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int garantia = Estoque31.validandoGarantia();
        String categoria = Estoque31.validandoCategoria();
        return  new ProdutosNaoPereciveis31(nome,preco,quantidade,estoqueMinimo,garantia,categoria);
    }

    private static void cadastroProdutoSistema(){
        String nome = Estoque31.validandoNome();
        double preco = Estoque31.validandoPreco();
        int quantidade = Estoque31.validandoQuantidade();
        int estoqueMinimo = Estoque31.validandoEstoqueMinimo();
        System.out.print("É produto Perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma resposta válida.");
            return;
        }
        ProdutoBase31 produtoBase31 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase31.verificarEstoqueMinimo();
        estoque31.addProdutoSistema(produtoBase31);
    }

    public static void excluirProduto(){
        String nome = Estoque31.validandoNome();
        estoque31.excluirDados(nome);
    }

    public static void pesquisaPorNome(){
        String nome = Estoque31.validandoNome();
        estoque31.exibirPesquisaPorNome(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        if (estoque31.getProdutoBase31s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        System.out.println("====Preço mínimo====");
        double precoMinimo = Estoque31.validandoPreco();
        System.out.println("====Preço mínimo====");
        double precoMaximo = Estoque31.validandoPreco();
        estoque31.listarProdutosFaixaDePreco(precoMinimo,precoMaximo);
    }

}
