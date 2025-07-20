package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque13;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto13;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo13;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis13;

import java.util.Scanner;

public class ProdutoTest13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque13 estoque13 = new Estoque13();
        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa de produtos.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Retiriar produtos vencidos.");
            System.out.println("[6] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastrarPessoas(scanner, estoque13);
                    break;
                case 2:
                    estoque13.listarProdutos(scanner);
                    break;
                case 3:
                    estoque13.pesquisaProduto(scanner);
                    break;
                case 4:
                    estoque13.excluindoProdutos(scanner);
                    break;
                case 5:
                    estoque13.excluindoProdutosVencidos();
                    break;
                case 6:
                    System.out.println(">>>Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastrarPessoas(Scanner scanner, Estoque13 estoque13){
        int codigo = Estoque13.validandoCodigo(scanner,estoque13.getProduto13s());
        String nome = Estoque13.validandoNome(scanner,estoque13);
        String categoria = Estoque13.validandoCategoria(scanner,estoque13);
        int quantidade = Estoque13.validandoQuantidade(scanner);
        double precoCompra = Estoque13.validandoPrecoCompra(scanner);
        double precoVenda = Estoque13.validandoPrecoVenda(scanner, precoCompra);
        String fornecedor = Estoque13.validandoFornecedor(scanner,estoque13);
        String temEstoqueMinimo = "";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
        }while (!temEstoqueMinimo.equalsIgnoreCase("sim")  && !temEstoqueMinimo.equalsIgnoreCase("não"));
        if (temEstoqueMinimo.equalsIgnoreCase("sim")){
            ProdutoComEstoqueMinimo13 produtoComEstoqueMinimo13 = ProdutoComEstoqueMinimo13.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque13.addProdutos(produtoComEstoqueMinimo13);
        }else {
            String ePerecivel="";
            do {
                System.out.print("Produto é perecível?(sim/não):");
                ePerecivel = scanner.nextLine().trim().toLowerCase();
            }while (!ePerecivel.equalsIgnoreCase("sim") && !ePerecivel.equalsIgnoreCase("não"));
            if (ePerecivel.equalsIgnoreCase("sim")){
                ProdutosPereciveis13 produtosPereciveis13  = ProdutosPereciveis13.validandoDataValidade(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque13.addProdutos(produtosPereciveis13);
            }else {
                Produto13 produto13 = new Produto13(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque13.addProdutos(produto13);
            }
        }
    }
}
