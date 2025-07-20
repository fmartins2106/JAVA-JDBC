package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque16;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase16;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel16;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis16;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest16 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque16 estoque = new Estoque16();

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
            codigoMenu(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Excluir produtos cadastrados.");
        System.out.println("[4] Listar produtos vencidos.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel16 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque16.validandoDataValidade();
        return new ProdutoPerecivel16(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis16 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque16.validandoMesesGarantia();
        String categoria = Estoque16.validandoCategoria();
        return new ProdutosNaoPereciveis16(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque16.validandoNome();
        double preco = Estoque16.validandoPreco();
        int quantidade = Estoque16.validandoQuantidade();
        int estoqueMinimo = Estoque16.validandoEstoqueMinimo();
        System.out.print("É produto perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Opção inválida, tente novamente.");
            return;
        }
        ProdutoBase16 produtoBase16 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase16.verificarEstoqueMinimo();

        estoque.addProdutoCarrinho(produtoBase16);
    }

    private static void excluirDadosProduto(){
        String nome = Estoque16.validandoNome();
        estoque.excluirProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        double precoMinimo = Estoque16.validandoPreco();
        double precoMaximo = Estoque16.validandoPreco();
        estoque.pesquisaPorPreco(precoMinimo,precoMaximo);
    }

    private static void codigoMenu(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque.listarProdutosCadastrados();
                break;
            case 3:
                excluirDadosProduto();
                break;
            case 4:
                estoque.listarProdutosVencidos();
                break;
            case 5:
              pesquisaPorFaixaDePreco();
              break;
            case 6:
                System.out.println(">>>Finalizando sistema.");
                return;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
