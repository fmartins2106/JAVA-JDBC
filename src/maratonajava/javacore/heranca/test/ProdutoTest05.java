package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque05;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto05;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo05;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis05;

import java.util.Scanner;

public class ProdutoTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque05 estoque05 = new Estoque05();
        while (true){
            System.out.println("[1]Cadastro produtos.");
            System.out.println("[2]Lista de produtos.");
            System.out.println("[3]Pesquisa produtos.");
            System.out.println("[4]Excluir produtos.");
            System.out.println("[5]Retirar produtos vencidos.");
            System.out.println("[6]Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastrandoProdutos(scanner,estoque05);
                    break;
                case 2:
                    estoque05.listaDeProdutos();
                    break;
                case 3:
                    estoque05.pesquisaPorProduto(scanner,estoque05.getProduto05s());
                    break;
                case 4:
                    estoque05.excluirProduto(scanner,estoque05.getProduto05s());
                    break;
                case 5:
                    estoque05.retirarProdutoVencido();
                    break;
                case 6:
                    System.out.println(">>>Finalizando o programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastrandoProdutos(Scanner scanner, Estoque05 estoque05){
        int codigo = Estoque05.validandoCodigo(scanner, estoque05.getProduto05s());
        String nome = Estoque05.validandoNome(scanner, estoque05);
        String categoria = Estoque05.validandoCategoria(scanner,estoque05);
        int quantidade = Estoque05.validandoQuantidade(scanner);
        double precoCompra = Estoque05.validandoPrecoCompra(scanner);
        double precoVenda = Estoque05.validandoPrecoVenda(scanner,precoCompra);
        String fornecedor = Estoque05.validandoFornecedor(scanner,estoque05);
        String temEstoqueMinimo="";
        do {
            System.out.print("Produto tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
        }while (!temEstoqueMinimo.equals("sim") && !temEstoqueMinimo.equals("não"));
        Produto05 produto;
        if (temEstoqueMinimo.equals("sim")){
            produto = ProdutoComEstoqueMinimo05.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }else {
            produto = new Produto05(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }
        String eProdutoPerecivel="";
        do {
            System.out.print("É produto perecível?(sim/não):");
            eProdutoPerecivel = scanner.nextLine().trim();
        }while (!eProdutoPerecivel.equals("sim") && !eProdutoPerecivel.equals("não"));
        if (eProdutoPerecivel.equals("sim")){
            ProdutosPereciveis05 produtosPereciveis05 = ProdutosPereciveis05.validandoProdutosPereciveis(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque05.addProdutos(produtosPereciveis05);
        }else {
            estoque05.addProdutos(produto);
        }
    }
}
