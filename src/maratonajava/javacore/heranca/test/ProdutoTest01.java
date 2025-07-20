package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Estoque01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Produto01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutoComEstoqueMinimo01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis01;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoTest01 {
    public static void main(String[] args) {
        Estoque01 estoque01 = new Estoque01();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Lista de produtos.");
            System.out.println("[3] Pesquisa produto por código.");
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
                    int codigo = Estoque01.validandoCodigo(scanner,estoque01.getProduto01s());
                    String nome = Estoque01.validandoNome(scanner);
                    String categoria = Estoque01.validandoCategoria(scanner);
                    int quantidade = Estoque01.validandoQuantidade(scanner);
                    double precoCompra = Estoque01.validandoPrecoCompra(scanner);
                    double precoVenda = Estoque01.validandoPrecoVenda(scanner,precoCompra);
                    String fornecedor = Estoque01.validandoFornecedor(scanner);
                    String temEstoqueMinimo="";
                    do {
                        System.out.print("Tem estoque mínimo?(sim/não):");
                        temEstoqueMinimo = scanner.nextLine().trim().toLowerCase();
                    }while (!temEstoqueMinimo.equals("sim") && !temEstoqueMinimo.equals("não"));
                    Produto01 produto01;
                    int estoqueMinimo;
                    if (temEstoqueMinimo.equalsIgnoreCase("sim")){
                        while (true){
                            try {
                                System.out.print("Digite o estoque mínimo:");
                                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                                if (estoqueMinimo < 50){
                                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                                    continue;
                                }
                                break;
                            }catch (NumberFormatException e) {
                                System.out.println("Digite um valor válido.");
                            }
                        }
                    produto01 = new ProdutoComEstoqueMinimo01(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
                    }else {
                        produto01 = new Produto01(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
                    }
                    String perecivel = "";
                    do {
                        System.out.print("Produto perecivel?(sim/não):");
                        perecivel  = scanner.nextLine().trim();
                    }while (!perecivel.equals("sim") && !perecivel.equals("não"));
                    if (perecivel.equalsIgnoreCase("sim")){
                        System.out.println("Digite a data de válidade (AAAA-MM-DD):");
                        LocalDate dataValidade;
                        try {
                            dataValidade = LocalDate.parse(scanner.nextLine());
                        }catch (Exception e){
                            System.out.println("Data inválida, digite no formato AAAA-MM-DD");
                            continue;
                        }
                        ProdutosPereciveis01 produtosPereciveis01 = new ProdutosPereciveis01(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
                        estoque01.addProdutoLista(produtosPereciveis01);
                    }else {
                        estoque01.addProdutoLista(produto01);
                    }
                    break;

                case 2:
                    estoque01.listaProdutos();
                    break;

                case 3:
                    estoque01.pesquisarPorCodigo(scanner);
                    break;

                case 4:
                    estoque01.excluirProduto(scanner);
                    break;

                case 5:
                    estoque01.retirandoProdutoVencido();
                    break;

                case 6:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
}
