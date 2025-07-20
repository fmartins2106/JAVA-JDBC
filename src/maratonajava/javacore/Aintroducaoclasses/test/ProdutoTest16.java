package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estoque16;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto16;

import java.util.Scanner;

public class ProdutoTest16 {
    public static void main(String[] args) {
        Estoque16 estoque16 = new Estoque16();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Alterar produto.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Pesquisar por produto.");
            System.out.println("[6] Produtos com estoque abaixo do mínimo.");
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
                    int codigo = Estoque16.validandoCodigo(scanner,estoque16.getProduto16s());
                    String nome = Estoque16.validandoNome(scanner);
                    String categoria = Estoque16.validandoCategoria(scanner);
                    double valor = Estoque16.validandoValor(scanner);
                    int quantidade = Estoque16.validandoQuantidade(scanner);
                    int estoqueMinimo = Estoque16.validandoEstoqueMinimo(scanner);
                    Produto16 produto16 = new Produto16(codigo,nome,categoria,valor,quantidade,estoqueMinimo);
                    estoque16.addProduto(produto16);
                    break;

                case 2:
                    estoque16.listarProdutos();
                    break;

                case 3:
                    estoque16.autualizarDadosProduto(scanner);
                    break;

                case 4:
                    estoque16.excluirDadosProduto(scanner);
                    break;

                case 5:
                    estoque16.pesquisaProdutoCodigo(scanner);
                    break;

                case 6:
                    estoque16.listaProdutoEstoqueBaixo();
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
