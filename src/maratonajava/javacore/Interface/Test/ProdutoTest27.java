package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque27;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase27;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel27;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis27;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest27 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque27 estoque27 = new Estoque27();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma da opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            metodoOpcoes(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produtos.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Exibir dados pesquisa.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastrarProdutoSistema();
                break;
            case 2:
                estoque27.listarProdutos();
                break;
            case 3:
                estoque27.listarProdutosVencidos();
                break;
            case 4:
                excluirDadosProduto();
                break;
            case 5:
                pesquisaPorNome();
                break;
            case 6:
                listarProdutosPorFaixaDePreco();
                break;
            case 7:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static ProdutoPerecivel27 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque27.validacaoDataValidade();
        return new ProdutoPerecivel27(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis27 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque27.validandoGarantia();
        String categoria = Estoque27.validandoCategoria();
        return new ProdutosNaoPereciveis27(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastrarProdutoSistema(){
        String nome = Estoque27.validandoNome();
        double preco = Estoque27.validandoPreco();
        int quantidade = Estoque27.validandoQuantidade();
        int estoqueMinimo = Estoque27.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma opção válida.");
            return;
        }
        ProdutoBase27 produtoBase27 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase27.verificarEstoqueMinimo();
        estoque27.addProdutoSistema(produtoBase27);
    }

    private static void excluirDadosProduto(){
        String nome = Estoque27.validandoNome();
        estoque27.excluirDadosProduto(nome);
    }

    private static void pesquisaPorNome(){
        String nome = Estoque27.validandoNome();
        estoque27.exibirPesquisaPorNome(nome);
    }

    private static void listarProdutosPorFaixaDePreco(){
        if (estoque27.getProdutoBase27s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        System.out.println("====Preço mínimo====");
        double precoMinimo = Estoque27.validandoPreco();
        System.out.println("====Preço máximo====");
        double precoMaximo = Estoque27.validandoPreco();
        estoque27.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

}
