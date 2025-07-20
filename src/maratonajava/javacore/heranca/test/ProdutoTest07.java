package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque07;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto07;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo07;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis07;

import java.util.Scanner;

public class ProdutoTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque07 estoque07 = new Estoque07();
        while (true){
            System.out.println("[1] Cadastro produto.");
            System.out.println("[2] Lista de produto.");
            System.out.println("[3] Pesquisa produto.");
            System.out.println("[4] Excluir produto.");
            System.out.println("[5] Retirar produto vencido.");
            System.out.println("[6] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma das opções acima.");
            }
            switch (opcao){
                case 1:
                    cadastroProduto(scanner,estoque07);
                    break;
                case 2:
                    estoque07.listarProdutos();
                    break;
                case 3:
                    estoque07.pesquisaProdutoCodigo(scanner);
                    break;
                case 4:
                    estoque07.excluirProduto(scanner);
                    break;
                case 5:
                    estoque07.retirarProdutoVencido();
                    break;
                case 6:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroProduto(Scanner scanner, Estoque07 estoque07 ){
        int codigo = Estoque07.validandoCodigo(scanner,estoque07.getProduto07s());
        String nome = Estoque07.validandoNome(scanner,estoque07);
        String categoria = Estoque07.validandoCategoria(scanner,estoque07);
        int quantidade = Estoque07.validandoQuantidade(scanner);
        double precoCompra = Estoque07.validandoPrecoCompra(scanner);
        double precoVenda = Estoque07.validandoPrecoVenda(scanner,precoCompra);
        String fornecedor = Estoque07.validandoFornecedor(scanner,estoque07);
        String temEstoqueMinimo= "";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim();
        }while (!temEstoqueMinimo.equals("sim") && !temEstoqueMinimo.equals("não"));
        Produto07 produto07 = null;
        if (temEstoqueMinimo.equals("sim")){
            produto07 = ProdutoComEstoqueMinimo07.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }else {
            produto07 = new Produto07(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }
        String eValido="";
        do {
            System.out.print("É produto perecivel?(sim/não):");
            eValido = scanner.nextLine().trim();
        }while (!eValido.equals("sim") && !eValido.equals("não"));
        if (eValido.equals("sim")){
            ProdutosPereciveis07 produtosPereciveis07 = ProdutosPereciveis07.validandoDataValidade(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque07.addProdutos(produtosPereciveis07);
        }else {
            estoque07.addProdutos(produto07);
        }
    }
}
