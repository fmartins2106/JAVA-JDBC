package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase20;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel20;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque20;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis20;


import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest20 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque20 estoque20 = new Estoque20();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
            codigoOpcoes(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }

    public static void exibirMenu(){
        System.out.println("[1] cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrado.");
        System.out.println("[3] Pesquisa por nome.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Listar produtos vencidos.");
        System.out.println("[7] Sair.");
    }

    public static ProdutoPerecivel20 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate vencimento = Estoque20.validandoDataValidade();
        return new ProdutoPerecivel20(nome,preco,quantidade,estoqueMinimo,vencimento);
    }

    public static ProdutosNaoPereciveis20 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque20.validandoMesesGarantia();
        String categoria = Estoque20.validandoCategoria();
        return new ProdutosNaoPereciveis20(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    public static void cadastroProduto(){
        String nome = Estoque20.validandoNomeProduto();
        double preco = Estoque20.validandoPrecoProduto();
        int quantidade = Estoque20.validandoQuantidade();
        int estoqueMinimo = Estoque20.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél? (sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Resposta inválida. Tente novamente.");
            return;
        }
        ProdutoBase20 produtoBase20 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase20.verificarEstoqueMinimo();

        estoque20.addProdutoSistema(produtoBase20);
    }

    private static void excluirProduto(){
        String nome = Estoque20.validandoNomeProduto();
        estoque20.excluirProdutoSistema(nome);
    }

    private static void pesquisaPorNome(){
        String nome = Estoque20.validandoNomeProduto();
        estoque20.exibirPesquisaPorNome(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque20.getProdutoBase20s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque20.validandoPrecoProduto();
        double precoMaximo = Estoque20.validandoPrecoProduto();
        estoque20.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void codigoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque20.listarProdutoCadastrados();
                break;
            case 3:
                pesquisaPorNome();
                break;
            case 4:
                excluirProduto();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
            case 6:
                estoque20.listarProdutosVencidos();
                break;
            case 7:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
