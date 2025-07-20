package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto02;
import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.SistemaProdutos02;
import academy.devdojo.maratonajava.javacore.Interface.dominio.SistemaProdutos03;

import java.util.Scanner;

public class ProdutoApp03 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaProdutos03 sistemaProduto03 = new SistemaProdutos03();

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
                    sistemaProduto03.listarProdutos();
                    break;
                case 6:
                    sistemaProduto03.gerarRelatorioEstoque();
                    break;
                case 7:
                    System.out.println("Total em estoque R$"+sistemaProduto03.calcularValorTotalEstoque());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.");

            }

        }while (opcao != 8);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void addProduto(){
        String nome = SistemaProdutos03.validandoNome();
        double preco = SistemaProdutos03.validandoPreco();
        int quantidade = SistemaProdutos03.validandoQuantidade();
        String descricao = SistemaProdutos03.validandoDescricao();
        DadosProduto03 dadosProduto03 = new DadosProduto03(nome,preco,quantidade,descricao);
        if (sistemaProduto03.addProdutoSistema(dadosProduto03)){
            System.out.println("Produto adicionado no sistema.");
            return;
        }
        System.out.println("Produto já existe.");
    }

    private static void atualizarProduto(){
        String nome = SistemaProdutos03.validandoNome();
        double preco = SistemaProdutos03.validandoPreco();
        int quantidade = SistemaProdutos03.validandoQuantidade();
        String descricao = SistemaProdutos03.validandoDescricao();
        if (sistemaProduto03.atualizarProduto(nome,preco,quantidade,descricao)){
            System.out.println("Produto Atualizado.");
        }
    }

    private static void removerProduto(){
        String nome = SistemaProdutos03.validandoNome();
        if (sistemaProduto03.removerProduto(nome)){
            System.out.println("Produto removido do sistema.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }


    private static void buscarProduto(){
        String nome = SistemaProdutos03.validandoNome();
        DadosProduto03 produto03 = sistemaProduto03.buscarProduto(nome);
        if (produto03 != null){
            System.out.println(produto03);
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
                System.out.println(e.getMessage());
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar produto.");
        System.out.println("[2] Atualizar produto.");
        System.out.println("[3] Remover produto.");
        System.out.println("[4] Buscar produto.");
        System.out.println("[5] Listar produtos.");
        System.out.println("[6] Relatório de estoque.");
        System.out.println("[7] Valor total em estoque.");
        System.out.println("[8] Sair.");
    }

}
