package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis03;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest03 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque03 estoque = new Estoque03();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            processarOpcao(opcao);
        }while (opcao != 7);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar produto.");
        System.out.println("[2] Listar produtos.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Remover produtos.");
        System.out.println("[5] Alterar estoque.");
        System.out.println("[6] Filtrar produtos por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    public static ProdutoBase03 criarProdutoPerecevivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque03.validandoDataValidade(scanner);
        return new ProdutoPerecivel03(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    public static ProdutoBase03 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque03.mesesGarantia(scanner);
        String categoria = Estoque03.validandoCategoria(scanner);
        return new ProdutosNaoPereciveis03(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    public static void adicionarProduto(){
        String nome = Estoque03.validandoNome(scanner);
        double preco = Estoque03.validandoPreco(scanner);
        int quantidade = Estoque03.validandoQauntidade(scanner);
        int estoqueMinimo = Estoque03.validandoEstoqueMinimo(scanner);
        System.out.print("Produto é perecivél? (Sim | Não):");
        String tipoProduto = scanner.nextLine().trim();
        ProdutoBase03 produtoBase03 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecevivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        estoque.addProdutoSistema(produtoBase03);
    }

    private static void removerProduto(){
        String nome = Estoque03.validandoNome(scanner);
        estoque.removerProduto(nome);
    }

    private static void atualizarEstoque(){
        String nome = Estoque03.validandoNome(scanner);
        int quantidade = Estoque03.validandoQauntidade(scanner);
        estoque.atualizarEstoque(nome,quantidade);
    }

    private static void filtrarProdutoPorPreco(){
        double precoMinimo = Estoque03.validandoPreco(scanner);
        double precoMaxima = Estoque03.validandoPreco(scanner);
        estoque.filtrarPorFaixaDePreco(precoMinimo,precoMaxima);
    }

    public static void processarOpcao(int opcao){
        switch (opcao){
            case 1:
                adicionarProduto();
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
                filtrarProdutoPorPreco();
                break;
            default:
                System.out.println("Digite uma opção válida.");

        }
    }




}
