package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque14;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto14;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo14;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis14;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest14 {
    public static void main(String[] args) {
        Estoque14 estoque14 = new Estoque14();
        Scanner scanner = new Scanner(System.in);
       while (true){
           int opcao =0;
           System.out.println("[1] Cadastro de produto.");
           System.out.println("[2] Lista de produtos.");
           System.out.println("[3] Pesquisa produtos.");
           System.out.println("[4] Excluir produtos.");
           System.out.println("[5] Alterar dados Produto.");
           System.out.println("[6] Excluir produtos vencidos.");
           System.out.println("[7] Sair.");
           try {
               System.out.print("Digite uma das opções acima:");
               opcao = Integer.parseInt(scanner.nextLine());
           }catch (NumberFormatException e){
               System.out.println("Digite um valor válido.");
           }
           switch (opcao){
               case 1:
                   cadastroProduto(scanner,estoque14);
                   break;
               case 2:
                   estoque14.listaProdutos();
                   break;
               case 3:
                   estoque14.pesquisaPorNome(scanner);
                   break;
               case 4:
                   estoque14.excluindoProdutos(scanner);
                   break;
               case 5:
                   estoque14.alterandoDados(scanner,estoque14);
                   break;
               case 6:
                   estoque14.retirarProdutoVencido();
                   break;
               case 7:
                   System.out.println(">>>Finalizando programa...");
                   return;
               default:
                   System.out.println("Digite um valor válido.");
           }
       }
    }

    public static void cadastroProduto(Scanner scanner, Estoque14 estoque14){
        int codigo = Estoque14.validandoCodigo(scanner,estoque14,estoque14.getProduto14s());
        String nome = Estoque14.validandoNome(scanner,estoque14);
        String categoria = Estoque14.validandoCategoria(scanner,estoque14);
        int quantidade = Estoque14.validandoQuantidade(scanner, estoque14);
        double precoCompra = Estoque14.validandoPrecoCompra(scanner,estoque14);
        double precoVenda = Estoque14.validandoPrecoVenda(scanner,estoque14,precoCompra);
        String fornecedor = Estoque14.validadoFornecedor(scanner,estoque14);
        if (temEstoqueMinimo(scanner)){
            int estoqueMinimo = ProdutoComEstoqueMinimo14.validacaoEstoqueMinimo(scanner);
            ProdutoComEstoqueMinimo14 produtoComEstoqueMinimo14 = new ProdutoComEstoqueMinimo14(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
            estoque14.addProdutos(produtoComEstoqueMinimo14);
        }else{
            if (produtoPerecivel(scanner)){
                LocalDate dataValidade = ProdutosPereciveis14.validacaoDataValidade(scanner);
                ProdutosPereciveis14 produtosPereciveis14 = new ProdutosPereciveis14(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
                estoque14.addProdutos(produtosPereciveis14);
            }else {
                Produto14 produto14 = new Produto14(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque14.addProdutos(produto14);
            }
        }
    }

    private static boolean produtoPerecivel(Scanner scanner){
        String produtoPerecivel="";
        do {
            System.out.print("É produto perecivel?(sim/não):");
            produtoPerecivel = scanner.nextLine().trim();
        }while (!produtoPerecivel.equalsIgnoreCase("sim") && !produtoPerecivel.equalsIgnoreCase("não"));
        return (produtoPerecivel.equalsIgnoreCase("sim"));
    }

    private static boolean temEstoqueMinimo(Scanner scanner){
        String temEstoqueMinimo="";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim();
        }while (!temEstoqueMinimo.equalsIgnoreCase("sim") && !temEstoqueMinimo.equalsIgnoreCase("não"));
        return (temEstoqueMinimo.equalsIgnoreCase("sim"));
    }


}
