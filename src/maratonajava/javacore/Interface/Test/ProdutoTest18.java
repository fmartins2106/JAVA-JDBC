package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque18;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase18;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel18;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis18;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest18 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque18 estoque18 = new Estoque18();

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
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Excluir produto.");
        System.out.println("[4] Pesquisa por faixa de preço.");
        System.out.println("[5] Listar produtos vencidos.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel18 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque18.validandoDataValidade();
        return new ProdutoPerecivel18(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis18 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque18.validandoMesesGarantia();
        String categoria = Estoque18.validandoCategoria();
        return new ProdutosNaoPereciveis18(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque18.validandoNome();
        double preco = Estoque18.validacaoPreco();
        int quantidade = Estoque18.validandoQuantidade();
        int estoqueMinimo = Estoque18.validandoEstoqueMinimo();
        System.out.print("Produto é perecível ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Opção inválida. Tente novamente.");
            return;
        }
        ProdutoBase18 produtoBase18 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase18.verificarEstoqueMinimo();
        estoque18.addProdutoSistema(produtoBase18);
    }

    private static void excluirDados(){
        String nome = Estoque18.validandoNome();
        estoque18.excluirDadosProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque18.getProdutoBase18s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque18.validacaoPreco();
        double precoMaximo = Estoque18.validacaoPreco();
        estoque18.pesquisaPorFaixaDePreco(precoMinimo, precoMaximo);
    }

    private static void codigoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque18.listarProdutosCadastrados();
                break;
            case 3:
                excluirDados();
                break;
            case 4:
                pesquisaPorFaixaDePreco();
                break;
            case 5:
                estoque18.listarProdutosVencidos();
                break;
            case 6:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
