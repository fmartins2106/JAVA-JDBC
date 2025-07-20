package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque15;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto15;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosComEstoqueMinimo15;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis15;

import java.util.Scanner;

public class ProdutoTest15 {
    public static void main(String[] args) {
        Estoque15 estoque15 = new Estoque15();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] CadastroProdutos.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa por código.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Excluir produtos vencidos.");
            System.out.println("[7] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastroProduto(scanner,estoque15);
                    break;
                case 2:
                    estoque15.listaProdutos();
                    break;
                case 3:
                    estoque15.pesquisaProduto(scanner,estoque15);
                    break;
                case 4:
                    estoque15.excluirDadosProduto(scanner,estoque15);
                    break;
                case 5:
                    estoque15.alterandoDados(scanner,estoque15,estoque15.getProduto15s().get(0).getPrecoCompra());
                    break;
                case 6:
                    estoque15.excluirProdutosVencidos();
                    break;
                case 7:
                    System.out.println(">>>Finalizando Programa...");
                    return;
                default:
                    System.out.println("Digite uma das opções válidas, conforme menu.");
            }
        }
    }
    public static void cadastroProduto(Scanner scanner, Estoque15 estoque15){
        int codigo = Estoque15.validandoCodigo(scanner,estoque15);
        String nome = Estoque15.validandoNome(scanner,estoque15);
        String categoria = Estoque15.validandoCategoria(scanner,estoque15);
        int quantidade = Estoque15.validandoQuantidade(scanner,estoque15);
        double precoCompra = Estoque15.validandoPrecoCompra(scanner,estoque15);
        double precoVenda = Estoque15.validandoPrecoVenda(scanner,estoque15,precoCompra);
        String fornecedor = Estoque15.validandoFornecedor(scanner,estoque15);
        if (comEstoqueMinimo(scanner)){
            ProdutosComEstoqueMinimo15 produtosComEstoqueMinimo15 = ProdutosComEstoqueMinimo15.validandoDadosEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque15.addProdutos(produtosComEstoqueMinimo15);
        }else {
            if (ComDataDeValidade(scanner)){
                ProdutosPereciveis15 produtosPereciveis15 = ProdutosPereciveis15.validandoDadosProdutosPereciveis(scanner,codigo, nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque15.addProdutos(produtosPereciveis15);
            }else {
                Produto15 produto15 = new Produto15(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            }
        }
    }

    public static boolean comEstoqueMinimo(Scanner scanner){
        String temEstoqueMinimo="";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim();
        }while (!temEstoqueMinimo.equalsIgnoreCase("sim") && !temEstoqueMinimo.equalsIgnoreCase("não"));
        return (temEstoqueMinimo.equalsIgnoreCase("sim"));
    }

    public static boolean ComDataDeValidade(Scanner scanner){
        String eProdutoPerecivel="";
        do {
            System.out.print("É produto perecével?(sim/não):");
            eProdutoPerecivel = scanner.nextLine().trim();
        }while (!eProdutoPerecivel.equalsIgnoreCase("sim") && !eProdutoPerecivel.equalsIgnoreCase("não"));
        return (eProdutoPerecivel.equalsIgnoreCase("sim"));
    }

}
