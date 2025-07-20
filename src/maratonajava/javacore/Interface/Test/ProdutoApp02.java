package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto02;
import academy.devdojo.maratonajava.javacore.Interface.dominio.SistemaProdutos02;

import java.util.Scanner;

public class ProdutoApp02 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaProdutos02 sistemaProduto02 = new SistemaProdutos02();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            switch (opcao){
                case 1:
                    addProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    buscarProduto();
                    break;
                case 5:
                    sistemaProduto02.listarProdutos();
                    break;
                case 6:
                    sistemaProduto02.gerarRelatorioEstoque();
                    break;
                case 7:
                    System.out.println("Total em estoque:R$"+sistemaProduto02.calcularValorTotalEstoque());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }while (opcao != 8);
            System.out.println(">>>>Finalizando sistema.");
    }

    private static void addProduto(){
        String nome = SistemaProdutos02.validandoNome();
        double preco = SistemaProdutos02.validandoPreco();
        int quantidade = SistemaProdutos02.validandoQuantidade();
        String descricao = SistemaProdutos02.validandoDescricao();

        DadosProduto02 dadosProduto02 = new DadosProduto02(nome,preco,quantidade,descricao);
        if (sistemaProduto02.addProdutosSistema(dadosProduto02)){
            System.out.println("Produto adicionado.");
            return;
        }
        System.out.println("Produto já existe.");
    }

    private static void atualizarProduto(){
        String nome = SistemaProdutos02.validandoNome();
        double preco = SistemaProdutos02.validandoPreco();
        int quantidade = SistemaProdutos02.validandoQuantidade();
        String descricao = SistemaProdutos02.validandoDescricao();
        if (sistemaProduto02.atualizarProduto(nome,preco,quantidade,descricao)){
            System.out.println("Produto atualizado.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private static void removerProduto(){
        String nome = SistemaProdutos02.validandoNome();
        if (sistemaProduto02.removerProduto(nome)){
            System.out.println("Produto removido.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private static void buscarProduto(){
        String nome = SistemaProdutos02.validandoNome();
        DadosProduto02 produto02 = sistemaProduto02.buscarProduto(nome);
        if (produto02 != null){
            System.out.println(produto02);
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar produto.");
        System.out.println("[2] Atualizar produtos.");
        System.out.println("[3] Remover produto.");
        System.out.println("[4] Buscar produto.");
        System.out.println("[5] Listar produtos.");
        System.out.println("[6] Relatório de estoque.");
        System.out.println("[7] Valor total em estoque.");
        System.out.println("[8] Sair.");
    }
}
