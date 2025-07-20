package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque26;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase26;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel26;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis26;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest26 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque26 estoque26 = new Estoque26();

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
            metodosOpcao(opcao);
        }while (opcao != 7);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por nome.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    private static void metodosOpcao(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque26.listarProdutosCadastrados();
                break;
            case 3:
                estoque26.listarProdutosVencidos();
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
                break;
            default:
                System.out.println("Erro. Digite um número válido de opção.");
        }
    }


    private static ProdutoPerecivel26 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate vencimento = Estoque26.validandoDataValidade();
        return new ProdutoPerecivel26(nome,preco,quantidade,estoqueMinimo,vencimento);
    }

    private static ProdutosNaoPereciveis26 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque26.validandoGarantia();
        String categoria = Estoque26.validandoCategoria();
        return new ProdutosNaoPereciveis26(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque26.validandoNome();
        double preco = Estoque26.validandoPreco();
        int quantidade = Estoque26.validandoQuantidade();
        int estoqueMinimo = Estoque26.validandoEstoqueMinimo();
        System.out.print("É produtos perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma resposta válida.");
            return;
        }
        ProdutoBase26 produtoBase26 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase26.verificarEstoqueMinimo();
        estoque26.addProdutoSistema(produtoBase26);
    }

    private static void excluirProduto(){
        String nome = Estoque26.validandoNome();
        estoque26.excluirProdutoSistema(nome);
    }

    private static void pesquisaPorNome(){
        String nome = Estoque26.validandoNome();
        estoque26.exibirPesquisaPorNome(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque26.getProdutoBase26s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        System.out.println("====Preço mínimo====");
        double precoMinimo = Estoque26.validandoPreco();
        System.out.println("====Preço máximo====");
        double precoMaximo = Estoque26.validandoPreco();
        estoque26.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }
}
