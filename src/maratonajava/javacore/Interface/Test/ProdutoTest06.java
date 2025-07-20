package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque06;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase06;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel06;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis06;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest06 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque06 estoque = new Estoque06();

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
            mostrarOpcoes(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Listar produtos cadastrados.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Excluir produto.");
        System.out.println("[5] Filtrar produto por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel06 criarProdutoPerecivel(String nome, double preco, int quantidade, int estiqueMinimo){
        LocalDate dataValidade = Estoque06.validandoDataValidade(scanner);

        return new ProdutoPerecivel06(nome,preco,quantidade,estiqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis06 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque06.validandoMesGarantia(scanner);
        String categoria = Estoque06.validandoCategoria(scanner);

        return new ProdutosNaoPereciveis06(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque06.validacaoNome(scanner);
        double preco = Estoque06.validandoPreco(scanner);
        int quantidade = Estoque06.validandoQuantidade(scanner);
        int estoqueMinimo = Estoque06.validandoEstoqueMinimo(scanner);
        System.out.print("Produto é perecivél ?(sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        ProdutoBase06 produtoBase06 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase06.verificarEstoqueMinimo();
        estoque.addProdutoSistema(produtoBase06);
    }

    public static void removerProduto(){
        String nome = Estoque06.validacaoNome(scanner);
        estoque.removerProduto(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        if (estoque.getProdutoBase06s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque06.validandoPreco(scanner);
        double precoMaximo = Estoque06.validandoPreco(scanner);
        estoque.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void mostrarOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque.listarProdutoCadastrados();
                break;
            case 3:
                estoque.listarProdutoVencidos();
                break;
            case 4:
                removerProduto();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

}
