package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque15;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase15;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel15;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis15;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest15 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque15 estoque = new Estoque15();

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
            opcoesMenu(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Excluir dados produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel15 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque15.validandoDataValidade();

        return new ProdutoPerecivel15(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis15 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque15.validandoMesesGarantia();
        String categoria = Estoque15.validandoCategoria();

        return  new ProdutosNaoPereciveis15(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque15.validandoNome();
        double preco = Estoque15.validandoPreco();
        int quantidade = Estoque15.validandoQuantidade();
        int estoqueMinimo = Estoque15.validandoEstoqueMinimo();
        System.out.print("Produto perecivél ? (sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Digite um valor válido.");
            return;
        }
        ProdutoBase15  produtoBase15 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase15.verificarEstoqueMinimo();
        estoque.addOProdutoSistema(produtoBase15);
    }

    private static void excluirDados(){
        String nome = Estoque15.validandoNome();
        estoque.excluirDadosProduto(nome);
    }

    private static void pesquisaPorFaixaDePreco(){
        if (estoque.getProdutoBase15s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque15.validandoPreco();
        double precoMaximo = Estoque15.validandoPreco();
        estoque.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    private static void opcoesMenu(int opcao){
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
                excluirDados();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
        }
    }
}
