package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estoque15;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto15;

import java.util.Scanner;

public class ProtudoTest15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque15 estoque15 = new Estoque15();
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastrar produtos.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Atualizar dados produto.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Listar produtos com estoque baixo.");
            System.out.println("[6] Pesquisar produto por código.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opçõeos acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    int codigo = Estoque15.validandoCodigo(scanner,estoque15.getProduto15s());
                    String nome = Estoque15.validandoNome(scanner);
                    String categoria = Estoque15.validandoCategoria(scanner);
                    double valor = Estoque15.validandoValor(scanner);
                    int quantidade = Estoque15.validandoQuantidade(scanner);
                    int estoqueMinimo = Estoque15.validandoEstoqueMinimo(scanner);
                    Produto15 produto15 = new Produto15(codigo,nome,categoria,valor,quantidade,estoqueMinimo);
                    estoque15.addProdutos(produto15);
                    break;
                case 2:
                    estoque15.listandoProdutos();
                    break;
                case 3:
                    estoque15.atualizarDadosProduto(scanner);
                    break;
                case 4:
                    estoque15.excluirProduto(scanner);
                    break;
                case 5:
                    estoque15.listarProdutosEstoqueBaixo();
                    break;
                case 6:
                    estoque15.pesquisaProdutoCodigo(scanner);
                    break;
                case 7:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("Digite uma opção válida.");
            }
        }

    }
}
