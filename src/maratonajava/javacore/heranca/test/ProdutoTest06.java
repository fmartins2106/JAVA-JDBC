package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque06;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto06;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo06;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis06;

import java.util.Scanner;

public class ProdutoTest06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque06  estoque06 = new Estoque06();
        while (true){
            System.out.println("[1] Cadastrar produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa de produto.");
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
                    cadastroProduto(scanner,estoque06);
                    break;
                case 2:
                    estoque06.listaProdutos();
                    break;
                case 3:
                    estoque06.pesquisaPorProduto(scanner,estoque06.getProduto06s());
                    break;
                case 4:
                    estoque06.excluirProdutos(scanner,estoque06.getProduto06s());
                    break;
                case 5:
                    estoque06.retirandoProdutoVencido();
                    break;
                case 6:
                    System.out.println(">>>Finalizando programa....");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }

    }
    public static void cadastroProduto(Scanner scanner, Estoque06 estoque06){
        int codigo = Estoque06.validandoCodigo(scanner,estoque06.getProduto06s());
        String nome = Estoque06.validandoNome(scanner,estoque06);
        String categoria = Estoque06.validandoCategoria(scanner,estoque06);
        int quantidade = Estoque06.validandoQuantidade(scanner);
        double precoCompra = Estoque06.validandoPrecoCompra(scanner);
        double precoVenda = Estoque06.validandoPrecoVenda(scanner,precoCompra);
        String fornecedor = Estoque06.validandoFornecedor(scanner,estoque06);
        String temEstoqueMinimo="";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim();
        }while (!temEstoqueMinimo.equals("sim")  && !temEstoqueMinimo.equals("não"));
        Produto06 produto06;
        if (temEstoqueMinimo.equals("sim")){
            produto06 = ProdutoComEstoqueMinimo06.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }else {
            produto06 = new Produto06(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }
        String eProdutoPerecivel="";
        do {
            System.out.print("É produto perecível?(sim/não):");
            eProdutoPerecivel = scanner.nextLine().trim();
        }while (!eProdutoPerecivel.equals("sim") && !eProdutoPerecivel.equals("não"));
        if (eProdutoPerecivel.equals("sim")){
            ProdutosPereciveis06 produtosPereciveis06 = ProdutosPereciveis06.validandoProdutoPereciveis(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque06.addProdutosLista(produtosPereciveis06);
        }else {
            estoque06.addProdutosLista(produto06);
        }
    }
}
