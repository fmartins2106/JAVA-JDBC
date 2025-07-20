package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque02;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto02;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo02;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis02;

import java.util.Scanner;

public class ProdutoTest02 {
    public static void main(String[] args) {
        Estoque02 estoque02 = new Estoque02();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro produto.");
            System.out.println("[2] Listar produtos.");
            System.out.println("[3] Pesquisa produto por código.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Retirar produto vencido.");
            System.out.println("[6] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    int codigo = Estoque02.validandoCodigo(scanner,estoque02.getProduto02s());
                    String nome = Estoque02.validandoNome(scanner,estoque02);
                    String categoria = Estoque02.validandoCategoria(scanner,estoque02);
                    int quantidade = Estoque02.validandoQuantidade(scanner);
                    double precoCompra = Estoque02.validandoprecoCompra(scanner);
                    double precoVenda = Estoque02.validandoPrecoVenda(scanner, precoCompra);
                    String fornecedor = Estoque02.validandoFornecedor(scanner,estoque02);
                    String temEstoqueMinimo;
                    do {
                        System.out.print("Produto "+nome+" tem estoque mínimo?(sim/não):");
                        temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
                    }while (!temEstoqueMinimo.equals("sim") && !temEstoqueMinimo.equals("não"));
                    Produto02 produto;
                    if (temEstoqueMinimo.equals("sim")){
                        produto = ProdutoComEstoqueMinimo02.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                    }else {
                        produto = new Produto02(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                    }
                    String produtoPerecivel;
                    do {
                        System.out.print("Produto é perecivel?(sim/não):");
                        produtoPerecivel = scanner.nextLine().trim().toLowerCase();
                    }while (!produtoPerecivel.equals("sim") && !produtoPerecivel.equals("não"));
                    if (produtoPerecivel.equals("sim")) {
                        ProdutosPereciveis02 produtosPereciveis02 = ProdutosPereciveis02.validandoProdutosPereciveis2(scanner, codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
                        estoque02.addProduto(produtosPereciveis02);
                    }else {
                        estoque02.addProduto(produto);
                    }
                    break;

                case 2:
                    estoque02.listaProdutos();
                    break;

                case 3:
                    estoque02.pesquisaProdutoCodigo(scanner);
                    break;

                case 4:
                    estoque02.excluindoProduto(scanner,estoque02.getProduto02s());
                    break;

                case 5:
                    estoque02.retirarProdutoPorCodigo();
                    break;

                case 6:
                    System.out.println(">>>Finalizando>>>>");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }
}
