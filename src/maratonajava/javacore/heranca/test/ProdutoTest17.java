package academy.devdojo.maratonajava.javacore.heranca.test;


import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque17;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto17;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo17;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis17;

import java.util.Scanner;

public class ProdutoTest17 {
    public static void main(String[] args) {
        Estoque17 estoque17 = new Estoque17();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa por código.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Excluir produtos vencidos.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroProdutos(scanner,estoque17);
                        break;
                    case 2:
                        estoque17.listaProdutos();
                        break;
                    case 3:
                        estoque17.pesquisaPorCodigo(scanner,estoque17);
                        break;
                    case 4:
                        estoque17.excluirDados(scanner,estoque17);
                        break;
                    case 5:
                        estoque17.alterarDados(scanner,estoque17);
                        break;
                    case 6:
                        estoque17.excluirProdutosVencidos();
                        break;
                    case 7:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static void cadastroProdutos(Scanner scanner, Estoque17 estoque17){
        int codigo = Estoque17.validandoCodigo(scanner,estoque17);
        String nome = Estoque17.validandoNome(scanner,estoque17);
        String categoria =Estoque17.validandoCategoria(scanner,estoque17);
        int quantidade = Estoque17.validandoQuantidade(scanner,estoque17);
        double precoCompra = Estoque17.validandoPrecoCompra(scanner,estoque17);
        double precoVenda = Estoque17.validandoPrecoVenda(scanner,estoque17,precoCompra);
        String fornecedor = Estoque17.validandoFornecedor(scanner,estoque17);
        if (temEstoqueMinimo(scanner)){
            ProdutoComEstoqueMinimo17 produtoComEstoqueMinimo17 = ProdutoComEstoqueMinimo17.validandoDadosEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque17.addProdutos(produtoComEstoqueMinimo17);
        }else {
            if (temDataDeValidade(scanner)){
                ProdutosPereciveis17 produtosPereciveis17 = ProdutosPereciveis17.validandoDataValidade(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque17.addProdutos(produtosPereciveis17);
            }else {
                Produto17 produto17 = new Produto17(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque17.addProdutos(produto17);
            }
        }

    }

    public static boolean temEstoqueMinimo(Scanner scanner){
        String eEstoqueMinimo;
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            eEstoqueMinimo = scanner.nextLine().trim();
        }while (!eEstoqueMinimo.equalsIgnoreCase("sim") && !eEstoqueMinimo.equalsIgnoreCase("não"));
        return (eEstoqueMinimo.equalsIgnoreCase("sim"));
    }

    public static boolean temDataDeValidade(Scanner scanner){
        String eProdutoComValidade;
        do {
            System.out.print("Produto tem validade?(sim/não):");
            eProdutoComValidade = scanner.nextLine().trim();
        }while (!eProdutoComValidade.equalsIgnoreCase("sim") && !eProdutoComValidade.equalsIgnoreCase("não"));
        return (eProdutoComValidade.equalsIgnoreCase("sim"));
    }
}
