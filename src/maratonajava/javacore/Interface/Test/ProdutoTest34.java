package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest34 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque34 estoque34 = new Estoque34();
    private static final RelatorioEstoque34 relatorioEstoque34 = new RelatorioEstoque34();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            capturarEscolha(opcao);
        }while (opcao != 8);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void pesquisaPorNome(){
        String nome = Estoque34.validandoNome();
        estoque34.exibirPesquisaPorNome(nome);
    }

    private static void excluirDadosProduto(){
        String nome = Estoque34.validandoNome();
        estoque34.excluirDadosProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque34.getProdutoBase34s().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("=====Preço mínimo=====");
        double precoMinimo = Estoque34.validandoPreco();
        System.out.println("=====Preço máximo=====");
        double precoMaximo = Estoque34.validandoPreco();
        estoque34.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    private static ProdutoPerecivel34 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque34.validandoDataValidade();
        return new ProdutoPerecivel34(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis34 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int garantia = Estoque34.validandoMesesGarantia();
        String categoria = Estoque34.validandoCategoria();
        return new ProdutosNaoPereciveis34(nome,preco,quantidade,estoqueMinimo,garantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque34.validandoNome();
        double preco = Estoque34.validandoPreco();
        int quantidade = Estoque34.validandoQuantidade();
        int estoqueMinimo = Estoque34.validandoEstoqueMinimo();
        System.out.print("Produto é perecivéil ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Opção inválida.");
            return;
        }
        ProdutoBase34 produtos34 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        estoque34.addProdutoSistema(produtos34);
        produtos34.verificarEstoque();
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por nome.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Exportar relatório.");
        System.out.println("[8] Sair.");
    }

    private static void capturarEscolha(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque34.listarProdutos();
                break;
            case 3:
                estoque34.listarProdutosVencidos();
                break;
            case 4:
                excluirDadosProduto();
                break;
            case 5:
                pesquisaPorNome();
                break;
            case 6:
                pesquisaPorFaixaDePreco();
                break;
            case 7:
                relatorioEstoque34.gerarRelatorio(estoque34.getProdutoBase34s());
                break;
            case 8:
                break;
            default:
                System.out.println(">>>Finalizando sistema.");
        }
    }

}
