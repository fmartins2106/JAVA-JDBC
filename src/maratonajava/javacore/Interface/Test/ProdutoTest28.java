package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque28;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase28;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel28;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis28;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ProdutoTest28 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque28 estoque28 = new Estoque28();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirInfo();
            try {
                System.out.print("Digite um das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
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
                estoque28.listarProdutosSistema();
                break;
            case 3:
                estoque28.listarProdutosVencidos();
                break;
            case 4:
                excluirDadosProduto();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
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

    private static void exibirInfo(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Excluir produtos.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Pesquisa por nome.");
        System.out.println("[7] Sair.");
    }

    private static ProdutoPerecivel28 criarProdutoPerecivel(String nome, double valor, int quantidade, int estoqueMinimo){
        LocalDate vencimento = Estoque28.validandoDataValidade();
        return new ProdutoPerecivel28(nome,valor,quantidade,estoqueMinimo,vencimento);
    }

    private static ProdutosNaoPereciveis28 criarProdutoNaoPerecivel(String nome, double valor, int quantidade, int estoqueMinimo){
        int garantia = Estoque28.validandoGarantia();
        String categoria = Estoque28.validandoCategoria();
        return new ProdutosNaoPereciveis28(nome,valor,quantidade,estoqueMinimo,garantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque28.validandoNome();
        double preco = Estoque28.validandoPreco();
        int quantidade = Estoque28.validandoQuantidade();
        int estoqueMinimo = Estoque28.validandoEstoqueMinimo();
        System.out.print("É produto perecivél ? (sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite uma opção válida.");
            return;
        }
        ProdutoBase28 produtoBase28 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase28.verificarEstoque();
        estoque28.addProdutoEstoque(produtoBase28);
    }

    private static void excluirDadosProduto(){
        String nome = Estoque28.validandoNome();
        estoque28.excluirProdutoSistema(nome);
    }

    private static void pesquisaPorNome(){
        String nome = Estoque28.validandoNome();
        estoque28.exibirPesquisaPorNome(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque28.getProdutoBase28s().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("====Preço mínimo====");
        double precoMinimo = Estoque28.validandoPreco();
        System.out.println("====Preço máximo====");
        double precoMaximo = Estoque28.validandoPreco();
        estoque28.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

}

