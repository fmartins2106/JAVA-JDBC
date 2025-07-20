package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest30 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque30 estoque30 = new Estoque30();
    private static final RelatorioEstoque30 relatorio30 = new RelatorioEstoque30();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            metodoOpcoes(opcao);
        }while (opcao != 8);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque30.listaProdutosCadastrados();
                break;
            case 3:
                estoque30.listarProdutosVencidos();
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
                relatorio30.gerarRelatorioEstoque(estoque30.getProdutoBase30s());
                break;
            case 8:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produtos.");
        System.out.println("[5] Pesquisa por nome.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Exportar relatório.");
        System.out.println("[8] Sair.");
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

    private static ProdutoPerecivel30 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque30.validandoDataValidade();
        return new ProdutoPerecivel30(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis30 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque30.validandoGarantia();
        String categoria = Estoque30.validandoCategoria();
        return new ProdutosNaoPereciveis30(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque30.validandoNomeProduto();
        double preco = Estoque30.validandoPrecoProduto();
        int quantidade = Estoque30.validandoQuantidade();
        int estoqueMinimo = Estoque30.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél? [sim | não]:");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Opção inválida.");
            return;
        }
        ProdutoBase30 produtoBase30 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase30.verificarEstoqueMinimo();
        estoque30.addProdutoSistema(produtoBase30);
    }

    private static void pesquisaPorNome(){
        String nome = Estoque30.validandoNomeProduto();
        estoque30.exibirPesquisaNome(nome);
    }

    private static void excluirProduto(){
        String nome = Estoque30.validandoNomeProduto();
        estoque30.excluirProdutoSistema(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque30.getProdutoBase30s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        System.out.println("====Preço mínimo====");
        double precoMinimo = Estoque30.validandoPrecoProduto();
        System.out.println("====Preço máximo====");
        double precoMaximo = Estoque30.validandoPrecoProduto();
        estoque30.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

}
