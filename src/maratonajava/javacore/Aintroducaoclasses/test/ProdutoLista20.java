package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estoque20;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto20;

import java.util.Scanner;

public class ProdutoLista20 {
    public static void main(String[] args) {
        Estoque20 estoque20 = new Estoque20();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Aterar produto cadastrado.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Lista produtos com estoque abaixo do mínimo.");
            System.out.println("[6] Pequisa produto por nome.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
            switch (opcao){
                case 1:
                    int codigo = Estoque20.validandoCodigo(scanner,estoque20.getProduto20s());
                    String nome = Estoque20.validandoNome(scanner);
                    String categoria = Estoque20.validandoCategoria(scanner);
                    double valor = Estoque20.validandoValor(scanner);
                    int quantidade = Estoque20.validandoQuantidade(scanner);
                    int estoqueMinimo = Estoque20.validandoEstoqueMinimo(scanner);
                    Produto20 produto20 = new Produto20(codigo,nome,categoria,valor,quantidade,estoqueMinimo);
                    estoque20.addProdutoLista(produto20);
                    break;

                case 2:
                    estoque20.listaProdutos();
                    break;

                case 3:
                    estoque20.alterarDadosProduto(scanner);
                    break;

                case 4:
                    estoque20.excluirProdutoLista(scanner);
                    break;

                case 5:
                    estoque20.produtosEstoqueAbaixoMinimo();
                    break;

                case 6:
                    estoque20.pesquisaPorNome(scanner);
                    break;
                case 7:
                    System.out.println("Finalizando programa>>>.");
                    return;

                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
}
