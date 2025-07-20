package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque13 {
    private List<Produto13> produto13s;

    public Estoque13(){
        this.produto13s = new ArrayList<>();
    }

    public void addProdutos(Produto13 produto13){
        produto13s.add(produto13);
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println(Produto13.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto13.MENSAGEM_ERRO_CATEGORIA);
            return false;
        }
        return true;
    }

    private boolean validacaoFornecedor(String fornecedor){
        if (fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto13.MENSAGEM_ERRO_CATEGORIA);
            return false;
        }
        return true;
    }

    public static int validandoCodigo(Scanner scanner, List<Produto13> produto13s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < Produto13.CODIGO_MINIMO){
                    System.out.println(Produto13.MENSAGEM_ERRO_CODIGO);
                    continue;
                }
                if (produto13s.stream().anyMatch(p -> p.getCodigo()== codigo)){
                    System.out.println("Código já existente, tente outro.");
                    continue;
                }
                return codigo;
            }catch (NumberFormatException e){
                System.out.println("Digite um código válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner, Estoque13 estoque13){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque13.validacaoNome(nome)){
                return Produto13.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque13 estoque13){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque13.validacaoCategoria(categoria)){
                return Produto13.formatoNome(categoria);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < Produto13.QUANTIDADE_MINIMA){
                    System.out.println(Produto13.MENSAGEM_ERRO_QUANT_MINIMA);
                    continue;
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if ( precoCompra < Produto13.MINIMO_PRECO_COMPRA){
                    System.out.println(Produto13.MENSAGEM_ERRO_PRECO_COMPRA);
                    continue;
                }
                return precoCompra;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoVenda(Scanner scanner, double precoCompra){
        while (true){
            try {
                System.out.print("Preço venda:R$ ");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (precoVenda < precoCompra){
                    System.out.println(Produto13.MENSAGEM_ERRO_PRECO_VENDA);
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque13 estoque13){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque13.validacaoFornecedor(fornecedor)){
                return Produto13.formatoNome(fornecedor);
            }
        }
    }

    public void listarProdutos(Scanner scanner){
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto13s.forEach(System.out::println);
        }
    }

    public Produto13 pesquisaProduto(Scanner scanner){
        Produto13 produto13= null;
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            produto13 = produto13s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (produto13 != null){
                System.out.println("________________________________");
                System.out.println("Nome:"+produto13.getNome());
                System.out.println("Código:"+produto13.getCodigo());
                System.out.println("Quantidade:"+produto13.getQuantidade());
                System.out.println("Preço compra:R$"+produto13.getPrecoCompra());
                System.out.println("Preço venda:R$"+produto13.getPrecoVenda());
                System.out.println("Fornecedor:"+produto13.getFornecedor());
                System.out.println("________________________________");
            }else {
                System.out.println("Produto não encontrado");
                return null;
            }
        }
        return produto13;
    }

    public void excluindoProdutos(Scanner scanner){
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Produto13 produto13 = pesquisaProduto(scanner);
            if (produto13 != null){
                produto13s.remove(produto13);
                System.out.println("Produtos removido com sucesso.");
            }else {
                System.out.println("Produto não encontrado. Tente novamente.");
            }
        }
    }

    public void excluindoProdutosVencidos(){
        if (produto13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto13s.removeIf(produto13 -> produto13 instanceof ProdutosPereciveis13 &&
                    !((ProdutosPereciveis13)produto13).isValido());
            System.out.println("Produtos vencidos removidos com sucesso.");
        }
    }

    public List<Produto13> getProduto13s() {
        return produto13s;
    }

    public void setProduto13s(List<Produto13> produto13s) {
        this.produto13s = produto13s;
    }
}
