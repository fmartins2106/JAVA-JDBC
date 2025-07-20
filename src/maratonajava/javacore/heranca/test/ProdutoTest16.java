package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque16;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto16;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo16;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis16;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque16 estoque16 = new Estoque16();
        while (true){
            System.out.println("[1] Cadastro produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa por código.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Excluir produtos vencido.");
            System.out.println("[6] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroProduto(scanner,estoque16);
                    break;
                case 2:
                    estoque16.listaProdutos();
                    break;
                case 3:
                    estoque16.pesquisaProdutos(scanner,estoque16);
                    break;
                case 4:
                    estoque16.excluirDados(scanner,estoque16);
                    break;
                case 5:
                    estoque16.alterarDados(scanner,estoque16, estoque16.getProduto16s().get(0).getPrecoCompra());
                    break;
                case 6:
                    estoque16.retirandoProdutosVencidos();
                    break;
                case 7:
                    System.out.println(">>>Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroProduto(Scanner scanner, Estoque16 estoque16){
        int codigo = Estoque16.validandoCodigo(scanner, estoque16);
        String nome = Estoque16.validandoNome(scanner, estoque16);
        String categoria =Estoque16.validandoCategoria(scanner,estoque16);
        int quantidade = Estoque16.validandoQuantidade(scanner,estoque16);
        double precoCompra = Estoque16.validandoPrecoCompra(scanner, estoque16);
        double precoVenda = Estoque16.validandoPrecoVenda(scanner,estoque16,precoCompra);
        String fornecedor = Estoque16.validandoFornecedor(scanner, estoque16);
        if (comEstoqueMinimo(scanner)){
            int estoqueMinimo = ProdutoComEstoqueMinimo16.validandoEstoqueMinimo(scanner);
            ProdutoComEstoqueMinimo16 produtosPereciveis16 = new ProdutoComEstoqueMinimo16(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
            estoque16.addProdutos(produtosPereciveis16);
        }else {
            if (comDataValidade(scanner)){
                LocalDate dataValidade = ProdutosPereciveis16.validandoDataValidade(scanner);
                ProdutosPereciveis16 produtosPereciveis16 = new ProdutosPereciveis16(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
                estoque16.addProdutos(produtosPereciveis16);
            }else {
                Produto16 produto16 = new Produto16(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                estoque16.addProdutos(produto16);
            }
        }
    }

    public static boolean comEstoqueMinimo(Scanner scanner){
        String temEstoqueMinimo="";
        do {
            System.out.print("Tem estoque mínimo?(sim/não):");
            temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
        }while (!temEstoqueMinimo.equals("sim") && !temEstoqueMinimo.equals("não"));
        return (temEstoqueMinimo.equals("sim"));
    }

    public static boolean comDataValidade(Scanner scanner){
        String ePerecivel = "";
        do {
            System.out.print("Produto é perecível?(sim/não):");
            ePerecivel = scanner.nextLine().trim().toLowerCase();
        }while (!ePerecivel.equals("sim") && !ePerecivel.equals("não"));
        return (ePerecivel.equals("sim"));
    }

}
