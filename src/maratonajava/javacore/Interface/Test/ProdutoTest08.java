package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque08;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase08;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoPerecivel08;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosNaoPereciveis08;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class ProdutoTest08 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque08 estoque08 = new Estoque08();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
            listaOpcoes(opcao);
        }while (opcao != 6);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Lista de produtos cadastrados.");
        System.out.println("[3] Lista de produtos vencidos.");
        System.out.println("[4] Remover produto.");
        System.out.println("[5] Pesquisa por faixa de preço.");
        System.out.println("[6] Sair.");
    }

    private static ProdutoPerecivel08 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade = Estoque08.validandoDataValidade();

        return new ProdutoPerecivel08(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutosNaoPereciveis08 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque08.mesesGarantia();
        String categoria = Estoque08.validandoCategoria();

        return new ProdutosNaoPereciveis08(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void cadastroProduto(){
        String nome = Estoque08.validandoNome();
        double preco = Estoque08.validandoPreco();
        int quantidade = Estoque08.validandoQuantidade();
        int estoqueMinimo = Estoque08.estoqueMinimo();
        System.out.print("Produto é perecivel ? (sim | não):");
        String tipoProduto = scanner.nextLine().trim();
        if (!tipoProduto.equalsIgnoreCase("sim") && !tipoProduto.equalsIgnoreCase("não")){
            System.out.println("Digite uma opção válida. Tente novamente.");
            return;
        }
        ProdutoBase08 produtoBase08 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        produtoBase08.verificarEstoqueMinimo();
        estoque08.addProdutoSistema(produtoBase08);
    }

    private static void retirarProduto(){
        String nome = Estoque08.validandoNome();
        estoque08.removerProduto(nome);
    }

    private static void pesquisaPorFaixaPreco(){
        double precoMinimo = Estoque08.validandoPreco();
        double precoMaximo = Estoque08.validandoPreco();
        estoque08.filtrarProFaixaDePreco(precoMinimo,precoMaximo);
    }

    public static void listaOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroProduto();
                break;
            case 2:
                estoque08.listarProdutosCadastrados();
                break;
            case 3:
                estoque08.listarProdutosVencidos();
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
