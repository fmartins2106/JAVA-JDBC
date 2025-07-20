package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto04;
import academy.devdojo.maratonajava.javacore.Interface.dominio.SistemaProdutos04;

import java.util.Scanner;

public class ProdutoApp4 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaProdutos04 sistemaProdutos04 = new SistemaProdutos04();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirDetalhes();
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
                    sistemaProdutos04.listarProdutos();
                    break;
                case 6:
                    sistemaProdutos04.gerarRelatorioEstoque();
                    break;
                case 7:
                    System.out.println("Total em estoque R$"+sistemaProdutos04.calcularValorTotalEstoque());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }while (opcao != 8);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void buscarProduto(){
        String nome = SistemaProdutos04.validandoNome();
        DadosProduto04 produto04 = sistemaProdutos04.buscarProduto(nome);
        if (produto04 != null){
            System.out.println(produto04);
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private static void removerProduto(){
        String nome = SistemaProdutos04.validandoNome();
        if (sistemaProdutos04.removerProduto(nome)){
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public static void atualizarProduto(){
        String nome = SistemaProdutos04.validandoNome();
        double preco = SistemaProdutos04.validandoPreco();
        int quantidade = SistemaProdutos04.validandoQuantidade();
        String descricao = SistemaProdutos04.validandoDescricao();
        if (sistemaProdutos04.altualizarProduto(nome,preco,quantidade,descricao)){
            System.out.println("Produto atualizado.");
        }
    }

    public static void addProduto(){
        String nome = SistemaProdutos04.validandoNome();
        double preco = SistemaProdutos04.validandoPreco();
        int quantidade = SistemaProdutos04.validandoQuantidade();
        String descricao = SistemaProdutos04.validandoDescricao();
        DadosProduto04 dadosProduto04 = new DadosProduto04(nome,preco,quantidade,descricao);
        sistemaProdutos04.addProdutoSistema(dadosProduto04);
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digitre uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void exibirDetalhes(){
        System.out.println("[1] Adicionar produto.");
        System.out.println("[2] Atualizar produto.");
        System.out.println("[3] Remover Produto.");
        System.out.println("[4] Buscar produto.");
        System.out.println("[5] Listar produtos.");
        System.out.println("[6] Relatório de estoque.");
        System.out.println("[7] Valor total em estoque.");
        System.out.println("[8] Sair.");
    }
}
