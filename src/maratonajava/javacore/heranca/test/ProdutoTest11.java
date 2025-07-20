package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque11;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto11;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo11;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis11;

import java.util.Scanner;

public class ProdutoTest11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque11 estoque11 = new Estoque11();
        while (true){
            System.out.println("[1] Cadastro de produtos.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Remover produtos vencido.");
            System.out.println("[6] Sair.");
            int opcao=0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma das opções acima.");
            }
            switch (opcao){
                case 1:
                    cadastroProdutos(scanner,estoque11);
                    break;
                case 2:
                    estoque11.mostrarLista();
                    break;
                case 3:
                    estoque11.pesquisaNome(scanner);
                    break;
                case 4:
                    estoque11.excluindoProduto(scanner);
                    break;
                case 5:
                    estoque11.retirarProdutoVencido();
                    break;
                case 6:
                    System.out.println(">>>Finalizando o programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroProdutos(Scanner scanner, Estoque11 estoque11){
        int codigo = Estoque11.validandoCodigo(scanner,estoque11.getProduto11s());
        String nome = Estoque11.validandoNome(scanner,estoque11);
        String categoria = Estoque11.validandoCategoria(scanner,estoque11);
        int quantidade = Estoque11.validandoQuantidade(scanner);
        double precoCompra = Estoque11.validandoPrecoCompra(scanner);
        double precoVenda = Estoque11.validandoPrecoVenda(scanner,precoCompra);
        String fornecedor = Estoque11.validandoFornecedor(scanner,estoque11);
        String temEstoqueMinimo = "";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
        }while (!temEstoqueMinimo.equalsIgnoreCase("sim") && !temEstoqueMinimo.equalsIgnoreCase("não"));
        Produto11 produto11;
        if (temEstoqueMinimo.equalsIgnoreCase("sim")){
            produto11 = ProdutoComEstoqueMinimo11.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }else {
            produto11 = new Produto11(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }
        String ePerecivel="";
        do {
            System.out.print("Produto é perecivel?(sim/não):");
            ePerecivel = scanner.nextLine().trim().toLowerCase();
        }while (!ePerecivel.equalsIgnoreCase("sim") && !ePerecivel.equalsIgnoreCase("não"));
        if (ePerecivel.equalsIgnoreCase("sim")){
            ProdutosPereciveis11 produtosPereciveis11 = ProdutosPereciveis11.validandoDataValidade(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque11.addProdutos(produtosPereciveis11);
        }else {
            estoque11.addProdutos(produto11);
        }
    }
}
