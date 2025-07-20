package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque11;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase11;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel11;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis11;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest11 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque11 estoque = new Estoque11();

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
            cadastroOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando pedido.");
    }


    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel11 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque11.validacaoDataValidade();

        return new ProdutoPerecivel11(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis11 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque11.mesesGarantia();
        String categoria = Estoque11.validandoCategoria();

        return new ProdutosNaoPereciveis11(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque11.validacaoNome();
        double preco = Estoque11.validacaoPreco();
        int quantidade = Estoque11.validacaoQuantidade();
        int estoqueMinimo = Estoque11.validacaoEstoqueMinimo();

        System.out.print("Produto é perecivél?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma opção válida.");
            return;
        }
        ProdutoBase11 produtoBase11 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase11.verificarEstoqueMinimo();
        estoque.addProdutoSistema(produtoBase11);
    }

    private static void excluirProduto(){
        String nome = Estoque11.validacaoNome();
        estoque.excluirDados(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque.getProdutoBase11s().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        double precoMinimo = Estoque11.validacaoPreco();
        double precoMaximo = Estoque11.validacaoPreco();

        estoque.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    private static void cadastroOpcoes(int opcao){
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
                excluirProduto();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
            case 6:
                System.out.println(">>>Finalizando sistema.");
                return;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }


}
