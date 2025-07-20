package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis19;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest19 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque19 estoque = new Estoque19();

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
            codigoOpcoes(opcao);
        }while (opcao != 7);
        System.out.println(">>>Finalizando sistema.");
    }

    public static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Listar produtos.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Pesquisa por nome.");
        System.out.println("[5] Excluir produto.");
        System.out.println("[6] Pesquisa por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    public static ProdutoPerecivel19 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate validade = Estoque19.validandoDataValidade();
        return new ProdutoPerecivel19(nome,preco,quantidade,estoqueMinimo,validade);
    }

    public static ProdutosNaoPereciveis19 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int garantia = Estoque19.validandoMesesGarantia();
        String categoria = Estoque19.validandoCategoria();
        return new ProdutosNaoPereciveis19(nome,preco,quantidade,estoqueMinimo,garantia,categoria);
    }

    public static void cadastroProduto(){
        String nome = Estoque19.validandoNome();
        double preco = Estoque19.validandoPreco();
        int quantidade = Estoque19.validandoQuantidade();
        int estoqueMinimo = Estoque19.validandoEstoqueMinimo();
        System.out.print("Produto é perecível? (sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Erro. Resposta inválida, tente novamente.");
            return;
        }
        ProdutoBase19 produtoBase19 ="sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);

        produtoBase19.validarEstoqueMinimo();
        estoque.addProdutosSistema(produtoBase19);
    }

    public static void excluirDados(){
        String nome = Estoque19.validandoNome();
        estoque.excluirDados(nome);
    }

    public static void pesquisaPorNome(){
        String nome = Estoque19.validandoNome();
        estoque.exibirPesquisaPorNome(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        if (estoque.getProdutoBase19s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque19.validandoPreco();
        double precoMaximo = Estoque19.validandoPreco();
        estoque.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void codigoOpcoes(int opcao){
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
                pesquisaPorNome();
                break;
            case 5:
                excluirDados();
                break;
            case 6:
                pesquisaPorFaixaDePreco();
                break;
            case 7:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
