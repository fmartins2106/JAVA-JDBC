package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.*;

import java.util.Scanner;

public class ProdutoTest04 {
    public static void main(String[] args) {
        Estoque04 estoque04 = new Estoque04();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa por produto.");
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
                    cadastrandoProduto(scanner,estoque04);
                    break;
                case 2:
                    estoque04.listarProdutos();
                    break;
                case 3:
                    estoque04.pesquisaPorCodigo(scanner);
                    break;
                case 4:
                    estoque04.excluirProduto(scanner);
                    break;
                case 5:
                    estoque04.retirarProdutoVencido();
                    break;
                case 6:
                    System.out.println(">>Finalizando programa....");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastrandoProduto (Scanner scanner, Estoque04 estoque04){
        int codigo = Estoque04.valindandoCodigo(scanner,estoque04.getProduto04s());
        String nome = Estoque04.validandoNome(scanner,estoque04);
        String categoria = Estoque04.validandoCategoria(scanner,estoque04);
        double precoCompra = Estoque04.validandoPrecoCompra(scanner);
        double precoVenda = Estoque04.validandoPrecoVenda(scanner,precoCompra);
        int quantidade = Estoque04.validandoQuantidade(scanner);
        String fornecedor = Estoque04.validandoFornecedor(scanner,estoque04);
        String temEstoqueMinimo ="";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
        }while (!temEstoqueMinimo.equals("sim") && !temEstoqueMinimo.equals("não"));
        Produto04 produto;
        if (temEstoqueMinimo.equals("sim")){
            produto = ProdutoComEstoqueMinimo04.validandoEstoqueMinimo(scanner,codigo,nome,categoria,precoCompra,precoVenda,quantidade,fornecedor);
        }else {
            produto = new Produto04(codigo,nome,categoria,precoCompra,precoVenda,quantidade,fornecedor);
        }
        String eProdutoPerecivel="";
        do {
            System.out.print("Produto perecível?(sim/não):");
            eProdutoPerecivel = scanner.nextLine().trim().toLowerCase();
        }while (!eProdutoPerecivel.equals("sim") && !eProdutoPerecivel.equals("não"));
        if (eProdutoPerecivel.equals("sim")){
            ProdutosPereciveis04 produtosPereciveis04 = ProdutosPereciveis04.validandoProdutosPereciveis(scanner,codigo,nome,categoria,precoCompra,precoVenda,quantidade,fornecedor);
            estoque04.addProdutos(produtosPereciveis04);
        }else {
            estoque04.addProdutos(produto);
        }
    }
}
