package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest33 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque33 estoque33 = new Estoque33();
    private static final RelatorioEstoque33 relatorio = new RelatorioEstoque33();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            capturarOpcaoMenu(opcao);
        }while (opcao != 8);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static ProdutoPerecivel33 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque33.validandoDataValidade();
        return new ProdutoPerecivel33(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPerecivel33 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int garantia = Estoque33.validandoGarantia();
        String categoria  = Estoque33.validandoCategoria();
        return new ProdutosNaoPerecivel33(nome,preco,quantidade,estoqueMinimo,garantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque33.validandoNome();
        double preco = Estoque33.validandoPreco();
        int quantidade = Estoque33.validandoQuantidade();
        int estoqueMinimo = Estoque33.validandoEstoqueMinimo();
        System.out.println("Produto é perecivél?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma resposta válida.");
            return;
        }
        ProdutoBase33 produtoBase33 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        estoque33.addProdutoSistema(produtoBase33);
        produtoBase33.verificarEstoqueMinimo();
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

    private static void pesquisaPorNome(){
        String nome = Estoque33.validandoNome();
        estoque33.exibirPesquisaPorNome(nome);
    }

    private static void excluirDadosProduto(){
        String nome = Estoque33.validandoNome();
        estoque33.excluirProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque33.getProdutoBase33s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        System.out.println("====Preço mínimo====");
        double precoMinimo = Estoque33.validandoPreco();
        System.out.println("====Preço máximo====");
        double precoMaximo = Estoque33.validandoPreco();
        estoque33.listarProdutosPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    private static void capturarOpcaoMenu(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque33.listarProdutosSistema();
                break;
            case 3:
                estoque33.listarProdutosVencidos();
                break;
            case 4:
                pesquisaPorNome();
                break;
            case 5:
                excluirDadosProduto();
                break;
            case 6:
                pesquisaPorFaixaDePreco();
                break;
            case 7:
                relatorio.gerarRelatorio(estoque33.getProdutoBase33s());
                break;
            case 8:
                break;
            default:
                System.out.println("Erro. Nenhum produto foi cadastrado.");
        }
    }

     private static void exibirMenu(){
         System.out.println("[1] Cadastro produto.");
         System.out.println("[2] Lista de produtos cadastrados.");
         System.out.println("[3] Listar produtos vencidos.");
         System.out.println("[4] Pesquisa por nome.");
         System.out.println("[5] Excluir produto.");
         System.out.println("[6] Pesquisa por faixa de preço.");
         System.out.println("[7] Exportar relatório.");
         System.out.println("[8] Sair.");
     }
}
