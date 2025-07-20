package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque23;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase23;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel23;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis23;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest23 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque23 estoque23 = new Estoque23();

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

    public static void exibirMenu(){
        System.out.println("[1] Cadastro produto");
        System.out.println("[2] Lista de  produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Pesquisa por nome.");
        System.out.println("[5] Excluir produtos.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    public static ProdutoPerecivel23 criarProdutPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate vencimento = Estoque23.validandoDataVencimento();
        return new ProdutoPerecivel23(nome,preco,quantidade,estoqueMinimo,vencimento);
    }

    public static ProdutosNaoPereciveis23 criarProdutoNaoPerecive(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque23.validandoMesesGarantia();
        String categoria = Estoque23.validandoCategoria();
        return new ProdutosNaoPereciveis23(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    public static void cadastrarProduto(){
        String nome = Estoque23.validandoNome();
        double preco = Estoque23.validandoPreco();
        int quantidade = Estoque23.validandoQuantidade();
        int estoqueMinimo = Estoque23.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma opção válida.");
            return;
        }
        ProdutoBase23 produtoBase23 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecive(nome,preco,quantidade,estoqueMinimo);
        produtoBase23.verificarEstoqueMinimo();
        estoque23.addprodutoSistema(produtoBase23);
    }

    public static void pesquisaPorNome(){
        String nome = Estoque23.validandoNome();
        estoque23.exibirPesquisaPorNome(nome);
    }

    public static void excluirProduto(){
        String nome = Estoque23.validandoNome();
        estoque23.excluirProduto(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        if (estoque23.getProdutoBase23s().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("====Preço mínimo====");
        double precoMinimo = Estoque23.validandoPreco();
        System.out.println("====Preço Máximo====");
        double precoMaximo = Estoque23.validandoPreco();
        estoque23.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void codigoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastrarProduto();
                break;
            case 2:
                estoque23.listarProdutosCadastrados();
                break;
            case 3:
                estoque23.listarProdutosVencidos();
                break;
            case 4:
                pesquisaPorNome();
                break;
            case 5:
                excluirProduto();
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
