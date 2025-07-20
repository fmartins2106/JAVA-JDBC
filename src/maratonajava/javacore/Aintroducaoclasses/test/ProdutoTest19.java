package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estoque19;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.Scanner;

public class ProdutoTest19 {
    public static void main(String[] args) {
        Estoque19 estoque19 = new Estoque19();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Alterar dados produto.");
            System.out.println("[4] excluir produto.");
            System.out.println("[5] Produtos com estoque abaixo do mínimo.");
            System.out.println("[6] Pesquisa por código.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma da opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e ){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    int codigo = Estoque19.validandoCodigo(scanner,estoque19.getProduto19s());
                    String nome = Estoque19.validandoNome(scanner);
                    String categoria = Estoque19.validandoCategoria(scanner);
                    double valor = Estoque19.validandoValor(scanner);
                    int quantidade = Estoque19.validandoQuantidade(scanner);
                    int estoqueMinimo = Estoque19.validandoEstoqueMinimo(scanner);
                    Produto19 produto19 = new Produto19(codigo,nome,categoria,valor,quantidade,estoqueMinimo);
                    estoque19.addProdutos(produto19);
                    break;

                case 2:
                    estoque19.listaDeProdutos();
                    break;

                case 3:
                    estoque19.alterarDadosProduto(scanner);
                    break;

                case 4:
                    estoque19.excluirDadosProduto(scanner);
                    break;

                case 5:
                    estoque19.listaProdutosAbaixoMinimo();
                    break;

                case 6:
                    estoque19.pesquisaPorCodigo(scanner);
                    break;

                case 7:
                    System.out.println(">>>Finalizando o programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }
}
