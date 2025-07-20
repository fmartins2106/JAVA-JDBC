package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque09;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto09;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo09;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis09;

import java.util.Scanner;

public class ProdutoTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque09 estoque09 = new Estoque09();
        while (true){
            System.out.println("[1] Cadastro de pessoa.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Excluir produtos.");
            System.out.println("[4] pesquisa de código.");
            System.out.println("[5] Retirar produto vencido.");
            System.out.println("[6] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Opção inexistente.");
            }
            switch (opcao){
                case 1:
                    cadastroDeProdutos(scanner,estoque09);
                    break;
                case 2:
                    estoque09.validandoProduto();
                    break;
                case 3:
                    estoque09.excluirProduto(scanner);
                case 4:
                    estoque09.pesquisaCodigo(scanner);
                    break;
                case 5:
                    estoque09.retirarProdutoVencido();
                    break;
                case 6:
                    System.out.println(">>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroDeProdutos(Scanner scanner, Estoque09 estoque09){
        int codigo = Estoque09.validandoCodigo(scanner,estoque09.getProduto09s());
        String nome = Estoque09.validandoNome(scanner,estoque09);
        String categoria = Estoque09.validandoCategoria(scanner,estoque09);
        int quantidade = Estoque09.validandoQuantidade(scanner);
        double precoCompra = Estoque09.validandoPrecoCompra(scanner);
        double precoVenda = Estoque09.validandoPrecoVenda(scanner,precoCompra);
        String fornecedor = Estoque09.validandoFornecedor(scanner,estoque09);
        String temEstoqueMinimo="";
        do {
            System.out.print("Tem estoque mínimo?(sim/não)");
            temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
        }while (!temEstoqueMinimo.equals("sim") && !temEstoqueMinimo.equals("não"));
        Produto09 produto09;
        if (temEstoqueMinimo.equals("sim")){
            produto09 = ProdutoComEstoqueMinimo09.validandoEstoqueMinimo(scanner,codigo,nome,categoria, quantidade,precoCompra,precoVenda,fornecedor);
        }else {
            produto09 = new Produto09(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }
        String validade="";
        do {
            System.out.print("Produto perecivel?(sim/não):");
            validade = scanner.nextLine().trim().toLowerCase();
        }while (!validade.equals("sim") && !validade.equals("não"));
        if (validade.equals("sim")){
            ProdutosPereciveis09 produtosPereciveis09 = ProdutosPereciveis09.validandoDataValidade(scanner, codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque09.addProdutos(produtosPereciveis09);
        }else {
            estoque09.addProdutos(produto09);
        }
    }
}
