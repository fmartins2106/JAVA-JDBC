package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest32 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque32 estoque32 = new Estoque32();
    private static final RelatorioEstoque32 relatorioEstoque32 = new RelatorioEstoque32();
    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            metodoOpcoes(opcao);
        }while (opcao !=7);
        System.out.println(">>>Finalizando sistema.");
    }

    private static ProdutoPerecivel32 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque32.validandoDataValidade();
        return new ProdutoPerecivel32(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis32 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int garantia = Estoque32.validandoMesesGarantia();
        String categoria = Estoque32.validandoCatagoria();
        return new ProdutosNaoPereciveis32(nome,preco,quantidade,estoqueMinimo,garantia,categoria);
    }

    private static void cadastroProdutos(){
        String nome = Estoque32.validandoNome();
        double preco = Estoque32.validandoPreco();
        int quantidade = Estoque32.validandoQuantidade();
        int estoqueMinimo = Estoque32.validandoEstoqueMinimo();
        System.out.print("Produto é perecível ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro.Digite uma opção válida.");
            return;
        }
        ProdutoBase32 produtoBase32 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase32.verificarEstoque();
        estoque32.addProdutoSistema(produtoBase32);
    }

    private static void pesquisaPorNome(){
        String nome = Estoque32.validandoNome();
        estoque32.exibirPesquisaPorNome(nome);
    }

    private static void excluirDados(){
        String nome = Estoque32.validandoNome();
        estoque32.excluirDadosProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque32.getProdutoBase32s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        System.out.println("====Preço mínimo====");
        double precoMinimo = Estoque32.validandoPreco();
        System.out.println("====Preço máximo====");
        double precoMaximo = Estoque32.validandoPreco();
        estoque32.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
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
    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProdutos();
                break;
            case 2:
                estoque32.listarProdutosCadastrados();
                break;
            case 3:
                estoque32.listaDeProdutosVencidos();
                break;
            case 4:
                pesquisaPorNome();
                break;
            case 5:
                excluirDados();
                break;
            case 6:
                pesquisaPorFaixaDePreco();
                break;
            case 7:
                relatorioEstoque32.gerarRelatorio(estoque32.getProdutoBase32s());
                break;
            case 8:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Pesquisa por nome.");
        System.out.println("[5] Excluir dados.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Exportar lista de produtos.");
        System.out.println("[8] Sair.");
    }

}
