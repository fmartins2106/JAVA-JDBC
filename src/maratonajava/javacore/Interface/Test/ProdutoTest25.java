package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque25;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase25;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel25;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis25;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest25 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque25 estoque25 = new Estoque25();

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
            metodoMenuOpcoes(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }

    public static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por nome.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    public static void metodoMenuOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque25.listarProdutosSistema();
                break;
            case 3:
                estoque25.listarProdutosVencidos();
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

    public static ProdutoPerecivel25 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate validade = Estoque25.validandoDataValidade();
        return new ProdutoPerecivel25(nome,preco,quantidade,estoqueMinimo,validade);
    }

    public static ProdutosNaoPereciveis25 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque25.validandoMesesGarantia();
        String categoria = Estoque25.validandoCategoria();
        return new ProdutosNaoPereciveis25(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    public static void cadastroProduto(){
        String nome = Estoque25.validandoNome();
        double preco = Estoque25.validandoPreco();
        int quantidade = Estoque25.validandoQuantidade();
        int estoqueMinimo = Estoque25.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite apenas sim ou não, tente novamente.");
            return;
        }
        ProdutoBase25 produtoBase25 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase25.verificarEstoqueMinimo();
        estoque25.addProdutoSistema(produtoBase25);
    }

    public static void pesquisaPorNome(){
        String nome = Estoque25.validandoNome();
        estoque25.exibirPesquisaPorNome(nome);
    }

    public static void excluirProduto(){
        String nome = Estoque25.validandoNome();
        estoque25.excluirProduto(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        if (estoque25.getProdutoBase25s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        System.out.println("=====Preço mínimo=====");
        double precoMinimo = Estoque25.validandoPreco();
        System.out.println("=====Preço máximo=====");
        double precoMaximo = Estoque25.validandoPreco();
        estoque25.listarProdutosPorFaixaDePreco(precoMinimo,precoMaximo);
    }

}
