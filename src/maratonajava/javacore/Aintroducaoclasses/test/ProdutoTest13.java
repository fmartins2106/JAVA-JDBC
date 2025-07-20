package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estoque13;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto13;

import java.util.*;

public class ProdutoTest13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque13 estoque13 = new Estoque13();
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastrar produto.");
            System.out.println("[2] Listar produtos.");
            System.out.println("[3] Atualizar produto.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Listar produtos com estoque baixo.");
            System.out.println("[6] Busca produto por código.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    int codigo = Estoque13.validandoCodigo(scanner,estoque13.getProduto13s());
                    String nome = Estoque13.validandoNome(scanner);
                    String categoria = Estoque13.validandoCategoria(scanner);
                    double valor = Estoque13.validandoValor(scanner);
                    int quantidade = Estoque13.validandoQuantidade(scanner);
                    int estoqueMinimo = Estoque13.validandoEstoqueMinimo(scanner);
                    Produto13 produto13 = new Produto13(codigo,nome,categoria,valor,quantidade,estoqueMinimo);
                    estoque13.addEstoque(produto13);
                    break;

                case 2:
                    estoque13.listarProtudos();
                    break;

                case 3:
                    estoque13.atualizarProduto(scanner);
                    break;

                case 4:
                    estoque13.excluirProduto(scanner);
                    break;

                case 5:
                    estoque13.listaprodutosEstoqueBaixo();
                    break;

                case 6:
                    estoque13.buscarProdutoPorCodigo(scanner);
                    break;
                case 7:
                    System.out.println("Finalizando o programa....");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
