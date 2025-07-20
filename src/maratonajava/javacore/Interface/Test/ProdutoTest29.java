package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest29 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque29 estoque29 = new Estoque29();
    private static final RelatorioEstoque29 relatorioEstoque29 = new RelatorioEstoque29();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            metodosOpcao(opcao);
        }while (opcao != 8);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void metodosOpcao(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque29.listarProdutoCadastrados();
                break;
            case 3:
                estoque29.listarProdutoVencidos();
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
                relatorioEstoque29.gerarRelatorioEstoque(estoque29.getProdutoBase29s());
                break;
            case 8:
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por nome.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Relatório estoque.");
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

    private static ProdutoPerecivel29 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate validade = Estoque29.validandoDataValidade();
        return new ProdutoPerecivel29(nome,preco,quantidade,estoqueMinimo,validade);
    }

    private static ProdutoNaoPerecivel29 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int garantia = Estoque29.validandoGarantia();
        String categoria = Estoque29.validandoCategoria();
        return new ProdutoNaoPerecivel29(nome,preco,quantidade,estoqueMinimo,garantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque29.validandoNome();
        double preco = Estoque29.validandoPreco();
        int quantidade = Estoque29.validandoQuantidade();
        int estoqueMinimo = Estoque29.validandoEstoqueMinimo();
        System.out.print("Produto é perecivéil ?( sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Opção inválida, tente novamente.");
            return;
        }
        ProdutoBase29 produtoBase29 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase29.verificarEstoqueMinimo();
        estoque29.addProdutoSistema(produtoBase29);
    }

    private static void pesquisaPorNome(){
        String nome = Estoque29.validandoNome();
        estoque29.exibirPesquisaPorNome(nome);
    }

    private static void excluirProduto(){
        String nome = Estoque29.validandoNome();
        estoque29.excluirProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque29.getProdutoBase29s().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("====Preço míniomo====");
        double precoMinimo = Estoque29.validandoPreco();
        System.out.println("====Preço máximo====");
        double precoMaximo = Estoque29.validandoPreco();
        estoque29.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }




}
