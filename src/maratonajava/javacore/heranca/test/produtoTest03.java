package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque03;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto03;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo03;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis03;

import java.util.Scanner;

public class produtoTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque03 estoque03 = new Estoque03();
        while (true){
            System.out.println("[1] Cadatrar produto.");
            System.out.println("[2] Listar produtos.");
            System.out.println("[3] Pesquisa produto por código.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Retirar produto vencido.");
            System.out.println("[6] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastrandoProduto(scanner,estoque03);
                    break;
                case 2:
                    estoque03.listaProdutos();
                    break;
                case 3:
                    estoque03.pesquisarPorCodigo(scanner);
                    break;
                case 4:
                    estoque03.excluirProduto(scanner);
                    break;
                case 5:
                    estoque03.retirarProdutoVencido();
                    break;
                case 6:
                    System.out.println(">>Finalizando o programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastrandoProduto(Scanner scanner, Estoque03 estoque03){
        int codigo = Estoque03.validandoCodigo(scanner, estoque03.getProduto03s());
        String nome = Estoque03.validandoNome(scanner, estoque03);
        String categoria = Estoque03.validandoCategoria(scanner,estoque03);
        int quantidade = Estoque03.validandoQuantidade(scanner);
        double valorCompra = Estoque03.validandoPrecoCompra(scanner);
        double valorVenda = Estoque03.validandoPrecoVenda(scanner,valorCompra);
        String fornecedor = Estoque03.validandoFornecedor(scanner,estoque03);
        String temEstoqueMinimo= "";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim();
        }while (!temEstoqueMinimo.equals("sim")  && !temEstoqueMinimo.equals("não"));
        Produto03 produto;
        if (temEstoqueMinimo.equals("sim")){
            produto = ProdutoComEstoqueMinimo03.validandoProdutoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,valorCompra,valorVenda,fornecedor);
        }else {
            produto = new Produto03(codigo,nome,categoria,quantidade,valorCompra,valorVenda,fornecedor);
        }
        String temProdutoPerecivel="";
        do {
            System.out.print("Tem produto perecível?(sim/não):");
            temProdutoPerecivel = scanner.nextLine().trim().toLowerCase();
        }while (!temProdutoPerecivel.equals("sim")  && !temProdutoPerecivel.equals("não"));
        if (temProdutoPerecivel.equals("sim")){
            ProdutosPereciveis03 produtosPereciveis03 = ProdutosPereciveis03.validandoProdutosPereciveis(scanner,codigo,nome,categoria,quantidade,valorCompra,valorVenda,fornecedor);
            estoque03.addProdutos(produtosPereciveis03);
        }else {
            estoque03.addProdutos(produto);
        }
    }
}
