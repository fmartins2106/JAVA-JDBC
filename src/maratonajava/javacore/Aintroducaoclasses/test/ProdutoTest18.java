package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estoque18;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto18;

import java.util.Scanner;

public class ProdutoTest18 {
    public static void main(String[] args) {
        Estoque18 estoque18 = new Estoque18();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastrar produto.");
            System.out.println("[2] Listar produto.");
            System.out.println("[3] Alterar dados produto.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Lista produtos estoque abaixo do mínimo.");
            System.out.println("[6] Pesquisar produto por nome.");
            System.out.println("[7] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    int codigo = Estoque18.validandoCodigo(scanner,estoque18.getProduto18s());
                    String nome = Estoque18.validandoNome(scanner);
                    String categoria = Estoque18.validandoCategoria(scanner);
                    double valor = Estoque18.validandoValor(scanner);
                    int quantidade = Estoque18.validandoQuantidade(scanner);
                    int estoqueMinimo = Estoque18.validandoEstoqueMinimo(scanner);
                    Produto18 produto18 = new Produto18(codigo,nome,categoria,valor,quantidade,estoqueMinimo);
                    estoque18.addProduto(produto18);
                    break;

                case 2:
                    estoque18.listarProdutos();
                    break;

                case 3:
                    estoque18.alterarDadosProduto(scanner);
                    break;

                case 4:
                    estoque18.excluirProdutos(scanner);
                    break;

                case 5:
                    estoque18.listaEstoqueAbaixoMinimo();
                    break;

                case 6:
                    estoque18.pesquisaPorNome(scanner);
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
