package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque12;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto12;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo12;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis12;

import java.util.Scanner;

public class ProdutoTest12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque12 estoque12 = new Estoque12();
        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Remover produtos vencidos.");
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
                    cadastroProdutos(scanner,estoque12);
                    break;
                case 2:
                    estoque12.listarProdutos();
                    break;
                case 3:
                    estoque12.pesquisaProduto(scanner,estoque12);
                    break;
                case 4:
                    estoque12.excluirProdutos(scanner);
                    break;
                case 5:
                    estoque12.removendoProdutoVencido();
                    break;
                case 6:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroProdutos(Scanner scanner, Estoque12 estoque12){
        int codigo = Estoque12.validandoCodigo(scanner, estoque12.getProduto12s());
        String nome = Estoque12.validandoNome(scanner, estoque12);
        String categoria = Estoque12.validandoCategoria(scanner,estoque12);
        int quantidade = Estoque12.validandoQuantidade(scanner);
        double precoCompra = Estoque12.validandoPrecoCompra(scanner);
        double precoVenda = Estoque12.validandoPrecoVenda(scanner,precoCompra);
        String fornecedor = Estoque12.fornecedor(scanner,estoque12);
        String temEstoqueMinimo = "";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
        }while (!temEstoqueMinimo.equals("sim") && !temEstoqueMinimo.equals("não"));
        Produto12 produto12;
        if (temEstoqueMinimo.equals("sim")){
            produto12 = ProdutoComEstoqueMinimo12.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque12.addProdutosSistema(produto12);
        }else {
            String produtoPerecivel="";
            do {
                System.out.print("Produto é perecivel?(sim/não):");
                produtoPerecivel = scanner.nextLine().trim().toLowerCase();
            }while (!produtoPerecivel.equals("sim") && !produtoPerecivel.equals("não"));
            if (produtoPerecivel.equals("sim")){
                ProdutosPereciveis12 produtosPereciveis12 = ProdutosPereciveis12.validandoData(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque12.addProdutosSistema(produtosPereciveis12);
            }else {
                produto12 = new Produto12(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque12.addProdutosSistema(produto12);
            }
        }


    }
}
