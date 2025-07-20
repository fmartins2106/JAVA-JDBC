package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque07;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase07;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPerecivel07;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel07;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest07 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque07 estoque = new Estoque07();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Opção inválida. Tente novamente.");
            }
            exibirOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Listar produtos.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Excluir produto sistema.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[5] Sair.");
    }

    private static ProdutoPerecivel07 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque07.validandoDataValidade(scanner);

        return new ProdutoPerecivel07(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPerecivel07 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque07.validandoMesesGarantia(scanner);
        String categoria = Estoque07.validandoCategoria(scanner);

        return new ProdutosNaoPerecivel07(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque07.validacaoNome(scanner);
        double preco = Estoque07.validandoPreco(scanner);
        int quantidade = Estoque07.validandoQuantidade(scanner);
        int estoqueMinimo = Estoque07.validandoEstoqueMinimo(scanner);
        System.out.print("Produto é perecivél? (sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Opção inválida. Tente novamente.");
            return;
        }
        ProdutoBase07 produtoBase07 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase07.verificarEstoqueMinimo();
        estoque.addProdutoSistema(produtoBase07);
    }

    public static void retirarProduto(){
        if (estoque.getProdutoBase07s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        String nome = Estoque07.validacaoNome(scanner);
        estoque.removerProduto(nome);
    }

    public static void pesquisaPorFaixaDePreco(){
        if (estoque.getProdutoBase07s().isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double precoMinimo = Estoque07.validandoPreco(scanner);
        double precoMaximo = Estoque07.validandoPreco(scanner);
        estoque.filtrarProdutoPorFaixaDePreco(precoMinimo,precoMaximo);
    }


    private static void exibirOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque.listarProdutoCadastrados();
                break;
            case 3:
                estoque.listarProdutosVencidos();
                break;
            case 4:
                retirarProduto();
                break;
            case 5:
                pesquisaPorFaixaDePreco();
                break;
        }
    }
}
