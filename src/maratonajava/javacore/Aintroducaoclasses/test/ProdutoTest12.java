package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Loja12;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto12;

import java.util.*;

public class ProdutoTest12 {
    public static void main(String[] args) {
        Loja12 loja12 = new Loja12();
        Scanner scanner = new Scanner(System.in);

        while (true){
            int opcao =0;
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista produtos cadastrados.");
            System.out.println("[3] Pesquisa produto por nome.");
            System.out.println("[4] Alterar dados produto.");
            System.out.println("[5] Excluir produto.");
            System.out.println("[6] Lista produto por valor.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
            switch (opcao){
                case 1:
                    String nome = Loja12.validarNome(scanner);
                    double valor = Loja12.validandoValor(scanner);
                    String categoria = Loja12.validandoCategoria(scanner);
                    Produto12 produto12 = new Produto12(nome,valor,categoria);
                    loja12.addProdutosLista(produto12);
                    break;

                case 2:
                    loja12.tabelaProdutos(loja12.getProduto12s());
                    break;

                case 3:
                    loja12.pesquisaProdutoNome(scanner);
                    break;

                case 4:
                    loja12.alterarDadosProduto(scanner);
                    break;

                case 5:
                    loja12.excluirProduto(scanner);
                    break;

                case 6:
                    loja12.listaProdutoValor();
                    break;

                case 7:
                    System.out.println(">>>Finalizando sistema...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
