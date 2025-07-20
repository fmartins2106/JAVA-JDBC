package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque17;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase17;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel17;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis17;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest17 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque17 estoque = new Estoque17();

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
            codigoOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Listar produtos cadastrados.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel17 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate  dataValidade = Estoque17.validandoDataValidade();
        return new ProdutoPerecivel17(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis17 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque17.validandoMesesGarantia();
        String categoria = Estoque17.validandoCategoria();
        return new ProdutosNaoPereciveis17(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastrarProduto(){
        String nome = Estoque17.validandoNomeProduto();
        double preco = Estoque17.validandoPreco();
        int quantidade = Estoque17.validandoQuantidade();
        int estoqueMinimo = Estoque17.validandoEstoqueMinimo();
        System.out.print("É produto perecível? (sim | não):");
        String  tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Opção inválida. Tente novamente.");
            return;
        }
        ProdutoBase17 produtoBase17 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase17.verificarEstoqueMinimo();
        estoque.addProdutoSistema(produtoBase17);
    }

    private static void excluirProduto(){
        String nome = Estoque17.validandoNomeProduto();
        estoque.excluirDadosProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque.getProdutoBase17s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque17.validandoPreco();
        double precoMaximo = Estoque17.validandoPreco();
        estoque.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    private static void codigoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastrarProduto();
                break;
            case 2:
                estoque.listarProdutosCadastrados();
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
            case 6:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
