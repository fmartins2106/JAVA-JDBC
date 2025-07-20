package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest04 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque04 estoque = new Estoque04();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
            escolherOpcao(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Remover produto.");
        System.out.println("[5] Alterar estoque.");
        System.out.println("[6] Filtrar produtos por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    private static ProdutoBase04 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque04.validandoDataDeValidade(scanner);
        return new ProdutoPerecivel04(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutoBase04 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque04.validandoMesesGarantia(scanner);
        String categoria = Estoque04.valindandoCategoria(scanner);
        return new ProdutosNaoPereciveis04(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque04.validandoNome(scanner);
        double preco = Estoque04.validandoPreco(scanner);
        int estoqueMinimo = Estoque04.validandoEstoqueMinimo(scanner);
        int quantidade = Estoque04.validandoQuantidade(scanner);
        System.out.print("Produto é perecivel?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        ProdutoBase04 produtoBase04 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase04.verificarEstoqueMinimo();
        estoque.addProdutoSistema(produtoBase04);
    }

    private static void removerProduto(){
        String nome = Estoque04.validandoNome(scanner);
        estoque.removerProduto(nome);
    }

    private static void atualizarEstoque(){
        String nome = Estoque04.validandoNome(scanner);
        int quantidade = Estoque04.validandoQuantidade(scanner);
        estoque.atualizarEstoque(nome,quantidade);
    }

    private static void pesquisaPorFaixaPreco(){
        double precoMinimo = Estoque04.validandoPreco(scanner);
        double precoMaximo = Estoque04.validandoPreco(scanner);
        estoque.filtrarPorFaixaPreco(precoMinimo,precoMaximo);
    }

    public static void escolherOpcao(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque.listarProdutosCadastrados();
                break;
            case 3:
                estoque.listarProdutosVencidos();
                break;
            case 4:
                removerProduto();
                break;
            case 5:
                atualizarEstoque();
                break;
            case 6:
                pesquisaPorFaixaPreco();
                break;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

}
