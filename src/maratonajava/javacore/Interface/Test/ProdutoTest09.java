package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque09;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase09;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel09;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis09;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest09 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque09 estoque09 = new Estoque09();

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
            exibirOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>>Finalizando sistema.");
    }

    public static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Listar produtos cadastrado.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Remover produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    public static ProdutoPerecivel09 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque09.validandoDataValidade();

        return new ProdutoPerecivel09(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    public static ProdutosNaoPereciveis09 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque09.validandoMesesGarantia();
        String categoria = Estoque09.validandoCategoria();

        return new ProdutosNaoPereciveis09(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    public static void cadastroProduto(){
        String nome = Estoque09.validandoNome();
        double preco = Estoque09.validandoPreco();
        int quantidade = Estoque09.validandoQuantidade();
        int estoqueMinimo = Estoque09.validandoEstoqueMinimo();
        System.out.print("Produto é perecivél? (sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Digite uma opção válida.");
            return;
        }
        ProdutoBase09 produtoBase09 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase09.verificarEstoqueMinimo();
        estoque09.addProdutoSistema(produtoBase09);
    }

    public static void retirarProduto(){
        String nome = Estoque09.validandoNome();
        estoque09.removerProduto(nome);
    }

    public static void pesquisaPorFaixaPreco(){
        double precoMinimo = Estoque09.validandoPreco();
        double precoMaximo = Estoque09.validandoPreco();

        estoque09.pesquisaPorFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void exibirOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque09.listarProdutosCadastrados();
                break;
            case 3:
                estoque09.listarProdutosVencido();
                break;
            case 4:
                retirarProduto();
                break;
            case 5:
                pesquisaPorFaixaPreco();
                break;
        }
    }
}
