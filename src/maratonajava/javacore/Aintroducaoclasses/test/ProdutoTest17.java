package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estoque17;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto17;

import java.util.Scanner;

public class ProdutoTest17 {
    public static void main(String[] args) {
        Estoque17 estoque17 = new Estoque17();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastrar produto.");
            System.out.println("[2] lista produtos.");
            System.out.println("[3] Alterar produtos.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Lista estoque abaixo do mínimo.");
            System.out.println("[6] Pesquisa por nome.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    int codigo = Estoque17.validandoCodigo(scanner,estoque17.getProduto17s());
                    String nome = Estoque17.validandoNome(scanner);
                    String categoria = Estoque17.validandoCategoria(scanner);
                    double valor = Estoque17.validandoValor(scanner);
                    int quantidade = Estoque17.validandoQuantidade(scanner);
                    int estoqueMinimo = Estoque17.validandoEstoqueMinimo(scanner);
                    Produto17 produto17 = new Produto17(codigo,nome,categoria,valor,quantidade,estoqueMinimo);
                    estoque17.addProduto(produto17);
                    break;

                case 2:
                    estoque17.listarProdutos();
                    break;

                case 3:
                    estoque17.alterandoProdutos(scanner);
                    break;

                case 4:
                    estoque17.excluirProduto(scanner);
                    break;

                case 5:
                    estoque17.listarProdutosEstoqueBaixo(scanner);
                    break;

                case 6:
                    estoque17.pesquisaProdutoPorNome(scanner);
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
