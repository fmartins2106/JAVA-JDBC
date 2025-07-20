package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest02 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque02 estoque = new Estoque02();

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
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar Produto.");
        System.out.println("[2] Listar produtos.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Remover produtos.");
        System.out.println("[5] Atualizar estoque.");
        System.out.println("[6] Filtrar produtos por faixa de preço.");
        System.out.println("[7] Sair.");
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

    private static void adicionarProduto(){
        String nome = Estoque01.validandoNome(scanner);
        double preco = Estoque01.validandoPreco(scanner);
        int quantidade = Estoque01.validandoQuantidade(scanner);
        int estoqueMinimo = Estoque01.validandoEstoqueMinimo(scanner);
        System.out.println("Produto é Perecivél? (Sim | Não): ?");
        String tipoProduto = scanner.nextLine().trim();
        ProdutoBase02 produtoBase02 = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        estoque.addProdutoSistema(produtoBase02);
    }

    private static ProdutoBase02 criarProdutoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        LocalDate dataValidade =  Estoque02.validandoData(scanner);
        return new ProdutoPerecivel02(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutoBase02 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque02.validandoGarantia(scanner);
        String categoria = Estoque02.validandoCategoria(scanner);
        return new ProdutosNaoPereciveis02(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void removerProduto(){
        String nome = Estoque02.validandoNome(scanner);
        estoque.removerProduto(nome);
    }

    private static void atualizarEstoque(){
        String nome = Estoque02.validandoNome(scanner);
        int quantidade = Estoque02.validandoQuantidade(scanner);
        estoque.atualizarEstoque(nome,quantidade);
    }

    private static void filtrarProdutoPorPreco(){
        double precoMinimo = Estoque02.validandoPreco(scanner);
        double precoMaximo = Estoque02.validandoPreco(scanner);
        estoque.filtrarProFaixaDePreco(precoMinimo,precoMaximo);
    }


}
