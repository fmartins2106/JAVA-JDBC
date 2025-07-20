package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque08;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto08;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo08;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis08;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest08 {
    public static void main(String[] args) {
        Estoque08 estoque08 = new Estoque08();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Listar produtos.");
            System.out.println("[3] Pesquisa produto.");
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
                    cadastroDeProdutos(scanner,estoque08);
                    break;
                case 2:
                    estoque08.listaProdutos();
                    break;
                case 3:
                    estoque08.pesquisaProduto(scanner,estoque08.getProduto08s());
                    break;
                case 4:
                    estoque08.excluirProduto(scanner,estoque08.getProduto08s());
                    break;
                case 5:
                    estoque08.retirarProdutoVencido(scanner);
                    break;
                case 6:
                    System.out.println(">>>Finalizando....");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
    public static void cadastroDeProdutos(Scanner scanner, Estoque08 estoque08){
        int codigo = Estoque08.validandoCodigo(scanner, estoque08.getProduto08s());
        String nome = Estoque08.validandoNome(scanner,estoque08);
        String categoria = Estoque08.validandoCategoria(scanner,estoque08);
        int quantidade = Estoque08.validandoQuantidade(scanner);
        double precoCompra = Estoque08.validandoPrecoCompra(scanner);
        double precoVenda = Estoque08.validandoPrecoVenda(scanner,precoCompra);
        String fornecedor = Estoque08.validandoFornecedor(scanner, estoque08);
        String temEstoqueMinimo = "";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim();
        }while (!temEstoqueMinimo.equals("sim")  && !temEstoqueMinimo.equals("não"));
        Produto08 produto08= null;
        if (temEstoqueMinimo.equals("sim")){
            produto08 = ProdutoComEstoqueMinimo08.validandoEstoqueMinimo(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }else {
            produto08 = new Produto08(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
        }
        String ePerecivel="";
        do {
            System.out.print("Produto é perecivel?(sim/não):");
            ePerecivel = scanner.nextLine().trim().toLowerCase();
        }while (!ePerecivel.equals("sim") && !ePerecivel.equals("não"));
        if (ePerecivel.equals("sim")){
            ProdutosPereciveis08 produtosPereciveis08 = ProdutosPereciveis08.validandoDataValidade(scanner,codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
            estoque08.addProduto(produtosPereciveis08);
        }else {
            estoque08.addProduto(produto08);
        }
    }
}
