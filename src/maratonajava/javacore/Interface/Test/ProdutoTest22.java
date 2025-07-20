package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque22;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase22;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel22;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis22;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest22 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque22 estoque22 = new Estoque22();

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
            opcoesSistema(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto:");
        System.out.println("[2] Lista de produtos.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Pesquisa por nome.");
        System.out.println("[7] Sair.");
    }

    private static ProdutoPerecivel22 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate vencimento = Estoque22.validandoDataValidade();
        return new ProdutoPerecivel22(nome,preco,quantidade,estoqueMinimo,vencimento);
    }

    private static ProdutosNaoPereciveis22 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque22.validandoMesesGarantia();
        String categoria = Estoque22.validandoCategoria();
        return new ProdutosNaoPereciveis22(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastrarProduto(){
        String nome = Estoque22.validandoNome();
        double preco = Estoque22.validandoPreco();
        int quantidade = Estoque22.validandoQuantidade();
        int estoqueMinimo = Estoque22.validandoEstoqueMinimo();
        System.out.print("É produto perecível?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma opão válida.");
            return;
        }
        ProdutoBase22 produtoBase22  = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase22.verificarEstoqueMinimo();
        estoque22.addProdutoSistema(produtoBase22);
    }

    public static void pesquisaPorNome(){
        String nome = Estoque22.validandoNome();
        estoque22.exibirPesquisaPorNome(nome);
    }

    public static void excluirDadosProduto(){
        String nome = Estoque22.validandoNome();
        estoque22.excluirDados(nome);
        System.out.println("Produto excluido com sucesso.");
    }

    public static void pesquisaPorFaixaPreco(){
        if (estoque22.getProdutoBase22s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        System.out.println("=====Preço mínimo=====");
        double precoMinimo = Estoque22.validandoPreco();
        System.out.println("=====Preço máximo=====");
        double precoMaximo = Estoque22.validandoPreco();
        estoque22.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void opcoesSistema(int opcao){
        switch (opcao){
            case 1:
                cadastrarProduto();
                break;
            case 2:
                estoque22.listarProdutosSistemas();
                break;
            case 3:
                estoque22.listarProdutoVencidos();
                break;
            case 4:
                excluirDadosProduto();
                break;
            case 5:
                pesquisaPorFaixaPreco();
                break;
            case 6:
                pesquisaPorNome();
                break;
            case 7:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
