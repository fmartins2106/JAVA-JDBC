package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estoque14;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto14;

import java.util.*;

public class ProdutoTest14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque14 estoque14 = new Estoque14();

        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Listar produtos.");
            System.out.println("[3] Atualizar dados produtos.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Listar produtos baixo estoque.");
            System.out.println("[6] Buscar produtos por código.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    int codigo = Estoque14.validandoCodigo(scanner, estoque14.getProduto14s());
                    String nome = Estoque14.validandoNome(scanner);
                    String cagoria = Estoque14.validandoCategoria(scanner);
                    double valor = Estoque14.validandoValor(scanner);
                    int quantidade = Estoque14.validandoQuantidade(scanner);
                    int estoqueMinimo = Estoque14.validandoEstoqueMinimo(scanner);
                    Produto14 produto14 = new Produto14(codigo,nome,cagoria,valor,quantidade,estoqueMinimo);
                    estoque14.addProdutosEstoque(produto14);
                    break;

                case 2:
                    estoque14.listarProdutos();
                    break;

                case 3:
                    estoque14.atualizarValores(scanner);
                    break;

                case 4:
                    estoque14.excluirProduto(scanner);
                    break;

                case 5:
                    estoque14.listarProdutosBaixoEstoque();
                    break;

                case 6:
                    estoque14.buscaPorCodigoProduto(scanner);
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
