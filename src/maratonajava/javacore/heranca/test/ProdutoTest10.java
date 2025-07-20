package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque10;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto10;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo10;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis10;

import java.util.Scanner;

public class ProdutoTest10 {
    public static void main(String[] args) {
        Estoque10 estoque10 = new Estoque10();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa por Nome.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] remover produto vencido.");
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
                    cadastrandoProdutos(scanner,estoque10);
                    break;
                case 2:
                    estoque10.listaProdutos();
                    break;
                case 3:
                    estoque10.pesquisandoPOrNome(scanner);
                    break;
                case 4:
                    estoque10.excluindoProduto(scanner);
                    break;
                case 5:
                    estoque10.retirarProdutoVencido(scanner);
                    break;
                case 6:
                    System.out.println(">>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }
    public static void cadastrandoProdutos(Scanner scanner, Estoque10 estoque10){
        int codigo = Estoque10.validandoCodigo(scanner, estoque10.getProduto10s());
        String nome = Estoque10.validandoNomes(scanner,"Nome", estoque10);
        String categoria = Estoque10.validandoNomes(scanner, "Categoria", estoque10);
        int quantidade = Estoque10.validandoQuantidade(scanner);
        double precoCompra = Estoque10.validandoPreCompra(scanner);
        double precoVenda = Estoque10.validandoPrecoVenda(scanner,precoCompra);
        String fornecedor = Estoque10.validandoNomes(scanner, "Fornecedor", estoque10);
        String temEstoqueMinimo="";
        do {
            System.out.print("Tem estoque mínimo:");
            temEstoqueMinimo = scanner.nextLine().trim();
        }while (!temEstoqueMinimo.equalsIgnoreCase("sim")  && !temEstoqueMinimo.equalsIgnoreCase("não"));
        Produto10 produto10;
        if (temEstoqueMinimo.equalsIgnoreCase("sim")){
            produto10 = ProdutoComEstoqueMinimo10.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }else{
            produto10 = new Produto10(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }
        String ePerecivel="";
        do {
            System.out.print("Produto é perecivel?(sim/não):");
            ePerecivel = scanner.nextLine().trim().toLowerCase();
        }while (!ePerecivel.equalsIgnoreCase("sim") && !ePerecivel.equalsIgnoreCase("não"));
        if (ePerecivel.equalsIgnoreCase("sim")){
            ProdutosPereciveis10 produtosPereciveis10 = ProdutosPereciveis10.validandoProdutosPereciveis(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque10.addProdutos(produtosPereciveis10);
        }else {
            estoque10.addProdutos(produto10);
        }

    }
}
