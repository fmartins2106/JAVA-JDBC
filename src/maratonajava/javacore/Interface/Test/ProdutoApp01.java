package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto01;
import academy.devdojo.maratonajava.javacore.Interface.dominio.SistemaProdutos01;

import java.util.Scanner;

public class ProdutoApp01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaProdutos01 SISTEMA_PRODUTOS_01 = new SistemaProdutos01();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = capturandoOpcao();
            switch (opcao){
                case 1:
                    adicionarProduto();
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
                    SISTEMA_PRODUTOS_01.listarProdutos();
                    break;
                case 6:
                    SISTEMA_PRODUTOS_01.gerarRelatorioEstoque();
                    break;
                case 7:
                    System.out.println("Total em estoque:R$"+ SISTEMA_PRODUTOS_01.calcularValorTotalEstoque());
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        }while (opcao == 8);
        System.out.println(">>>>>Finalizando sistema.");
    }

    private static int capturandoOpcao(){
        while (true){
            try {
                System.out.println("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar produto.");
        System.out.println("[2] Atualizar produto.");
        System.out.println("[3] Remover produto.");
        System.out.println("[4] Buscar produto. ");
        System.out.println("[5] Listar produtos.");
        System.out.println("[6] Relatório de estoque.");
        System.out.println("[7] Valor total em estoque.");
        System.out.println("[8] Sair.");
        System.out.println("[9] Relatório de estoque.");
    }

    private static void adicionarProduto(){
        String nome = SistemaProdutos01.validandoNome();
        double preco = SistemaProdutos01.validandoPreco();
        int quantidade = SistemaProdutos01.validandoQuantidade();
        String descricao = SistemaProdutos01.validandoDescricao();

        DadosProduto01 produto01 = new DadosProduto01(nome,preco,quantidade,descricao);
        if (SISTEMA_PRODUTOS_01.addProduto(produto01)){
            System.out.println("Produto adicionado.");
            return;
        }
        System.out.println("Produto já existe.");
    }

    private static void atualizarProduto(){
        String nome = SistemaProdutos01.validandoNome();
        double preoc = SistemaProdutos01.validandoPreco();
        int quantidade = SistemaProdutos01.validandoQuantidade();
        String descricao = SistemaProdutos01.validandoDescricao();
        if (SISTEMA_PRODUTOS_01.altualzarProduto(nome,preoc,quantidade,descricao)){
            System.out.println("Produto atualizado.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private static void removerProduto(){
        String nome = SistemaProdutos01.validandoNome();
        if (SISTEMA_PRODUTOS_01.removerProduto(nome)){
            System.out.println("Produto removido.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private static void buscarProduto(){
        String nome = SistemaProdutos01.validandoNome();
        DadosProduto01 produto01 = SISTEMA_PRODUTOS_01.buscarProduto(nome);
        if (produto01 != null){
            System.out.println(produto01);
            return;
        }
        System.out.println("Produto não encontrado.");
    }
}
