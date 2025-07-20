package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProdutoTest01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Estoque01 estoque01 = new Estoque01();
    public static void main(String[] args) {
       int opcao;
       do {
           exibirMenu();
           opcao = Integer.parseInt(scanner.nextLine().trim());
           processarOpcao(opcao);
       }while (opcao != 7);
       scanner.close();
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar produto.");
        System.out.println("[2] Listar produtos.");
        System.out.println("[3] Listar produtos vencidos.");
        System.out.println("[4] Remover produto.");
        System.out.println("[5] Atualizar estoque.");
        System.out.println("[6] Filtrar produtos por faixa de preço.");
        System.out.println("[7] Sair.");
    }

    private static void processarOpcao(int opcao){
        switch (opcao){
            case 1:
                adicionarProduto();
                break;
            case 2:
                estoque01.listarProdutos();
                break;
            case 3:
                estoque01.listarProdutosVencidos();
                break;
            case 4:
                removerProduto();
                break;
            case 5:
                atualizarEstoque();
                break;
            case 6:
                filtrarProdutoPorPreco();
                break;
            case 7:
                System.out.println("<Finalizando sistema>");
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

    private static void adicionarProduto(){
        String nome = Estoque01.validandoNome(scanner);
        double preco = Estoque01.validandoPreco(scanner);
        int quantidade = Estoque01.validandoQuantidade(scanner);
        int estoqueMinimo = Estoque01.validandoEstoqueMinimo(scanner);
        System.out.print("Produto é perecivél?(sim|não):");
        String tipoProduto = scanner.nextLine().trim();
        ProdutoBase01 produto  = "sim".equalsIgnoreCase(tipoProduto) ? criarProdutoPerecivel(nome,preco,quantidade,estoqueMinimo) :
                criarProdutoNaoPerecivel(nome,preco,quantidade,estoqueMinimo);
        estoque01.addProdutoSistema(produto);

    }

    private static ProdutoBase01 criarProdutoPerecivel(String nome,double preco, int quantidade, int estoqueMinimo){
        System.out.print("Data de validade(YYYY-MM-DD):");
        String dataValidadeStr = scanner.nextLine().trim();
        LocalDate dataValidade = LocalDate.parse(dataValidadeStr, DateTimeFormatter.ISO_DATE);
        return new ProdutoPerecivel01(nome,preco,quantidade,estoqueMinimo,dataValidade);
    }

    private static ProdutoBase01 criarProdutoNaoPerecivel(String nome, double preco, int quantidade, int estoqueMinimo){
        int mesesGarantia = Estoque01.validandoMesesGarantia(scanner);
        String categoria = Estoque01.validandoCategoria(scanner);
        return new ProdutosNaoPereciveis01(nome,preco,quantidade,estoqueMinimo,mesesGarantia,categoria);
    }

    private static void removerProduto(){
        String nome = Estoque01.validandoNome(scanner);
        estoque01.removerProduto(nome);
    }

    private static void atualizarEstoque(){
        String nome = Estoque01.validandoNome(scanner);
        int quantidade = Estoque01.validandoQuantidade(scanner);
        estoque01.atualizarEstoque(nome,quantidade);
    }

    private static void filtrarProdutoPorPreco(){
        try {
            System.out.print("Digite o preço mínimo:R$");
            double precoMinimo = Double.parseDouble(scanner.nextLine().trim());
            if (precoMinimo < 0){
                System.out.println("Preço inválido.");
                return;
            }
            System.out.print("Digite o preço máximo:R$");
            double precoMaximo = Double.parseDouble(scanner.nextLine().trim());
            estoque01.filtrarProdutoPorFaixaPreco(precoMinimo,precoMaximo);
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

}
