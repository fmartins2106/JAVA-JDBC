package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque12;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase12;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel12;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis12;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest12 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque12 estoque = new Estoque12();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opçõe acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            metodoOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando pedido.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    public static ProdutoPerecivel12 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque12.validandoDataValidade();

        return new ProdutoPerecivel12(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    public static ProdutosNaoPereciveis12 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque12.validandoMesesGarantia();
        String categoria = Estoque12.validandoCategoria();

        return new ProdutosNaoPereciveis12(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    public static void cadastrarProduto(){
        String nome = Estoque12.validandoNome();
        double preco = Estoque12.validandoPreco();
        int quantidade = Estoque12.validandoQuantidade();
        int estoqueMinimo = Estoque12.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma opção válida.");
            return;
        }
        ProdutoBase12 produtoBase12 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase12.verificarEstoqueMinimo();

        estoque.addProdutoSistema(produtoBase12);
    }

    public static void excluirDados(){
        String nome = Estoque12.validandoNome();
        estoque.excluirDados(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        double precoMinimo = Estoque12.validandoPreco();
        double precoMaximo = Estoque12.validandoPreco();
        estoque.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastrarProduto();
                break;
            case 2:
                estoque.listarProdutosCadastrados();
                break;
            case 3:
                estoque.listarProdutosVencidos();
                break;
            case 4:
                excluirDados();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
