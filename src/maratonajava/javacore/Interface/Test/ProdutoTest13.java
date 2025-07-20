package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque13;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase13;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel13;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis13;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest13 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque13 estoque = new Estoque13();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
            executarOpcoesMenu(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos  vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel13 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque13.validandoDataValidade();

        return new ProdutoPerecivel13(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis13 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque13.validandoMesesGarantia();
        String categoria = Estoque13.validandoCategoria();

        return new ProdutosNaoPereciveis13(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque13.validandoNome();
        double preco = Estoque13.validandoPreco();
        int quantidade = Estoque13.validandoQuantidade();
        int estoqueMinimo = Estoque13.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél ? (Sim | Não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite apenas sim ou não.");
            return;
        }
        ProdutoBase13 produtoBase13 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase13.verificarEstoqueMinimo();

        estoque.addProdutoSistema(produtoBase13);
    }

    private static void excluirProduto(){
        String nome = Estoque13.validandoNome();
        estoque.excluirProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque.getProdutoBase13s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque13.validandoPreco();
        double precoMaximo = Estoque13.validandoPreco();
        estoque.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void executarOpcoesMenu(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque.listarProdutos();
                break;
            case 3:
                estoque.listarProdutoVencidos();
                break;
            case 4:
                excluirProduto();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
