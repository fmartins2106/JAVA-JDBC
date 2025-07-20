package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis05;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest05 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque05 estoque = new Estoque05();

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
        }while (opcao != 6);
        System.out.println(">>>>Finalizando sistema.");
    }


    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos.");
        System.out.println("[4] Remover produto.");
        System.out.println("[5] Filtrar produtos por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoBase05 cadastroProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque05.validandoDataValidade(scanner);
         return new ProdutoPerecivel05(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutoBase05 cadastroProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque05.validandoMesesGarantia(scanner);
        String categoria = Estoque05.validandoCategoria(scanner);
        return new ProdutosNaoPereciveis05(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque05.validandoNome(scanner);
        double preco = Estoque05.validandoPreco(scanner);
        int quantidade = Estoque05.validandoQuantidade(scanner);
        int estoqueMinimo = Estoque05.validandoEstoqueMinimo(scanner);
        System.out.print("Produto é perecivél? (Sim | Não):");
        String tipoProduto = scanner.nextLine().trim();
        ProdutoBase05 produtoBase05 =  "sim".equalsIgnoreCase(tipoProduto) ? cadastroProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                cadastroProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase05.verificarEstoqueMinimo();
        estoque.addProdutoSistema(produtoBase05);
    }

    private static void removerProduto(){
        String nome = Estoque05.validandoNome(scanner);
           estoque.removerProduto(nome);
    }

    public static void atualizarEstoque(){
        String nome = Estoque05.validandoNome(scanner);
        int quantidade = Estoque05.validandoQuantidade(scanner);
        estoque.atualiarEstoque(nome,quantidade);
    }

    public static void pesquisaPorPreco(){
        double precoMinimo = Estoque05.validandoPreco(scanner);
        double precoMaximo = Estoque05.validandoPreco(scanner);
        estoque.filtrarPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void escolherOpcao(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque.listarProdutos();
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
                pesquisaPorPreco();
                break;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
