package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque06 {
    private List<Produto06> produto06s;

    public Estoque06(){
        this.produto06s = new ArrayList<>();
    }

    public void addProdutosLista(Produto06 produto06){
        produto06s.add(produto06);
    }

    private static final int MENOR_CODIGO =1;
    public static int validandoCodigo(Scanner scanner, List<Produto06> produto06s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < MENOR_CODIGO){
                    System.out.println("Código não pode ser menor que 1.");
                    continue;
                }
                if (produto06s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                    System.out.println("Código já consta no sistema, tente outro.");
                }else {
                    return codigo;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private boolean validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo "+palavra+ " não pode ser vazio ou conter caracteres. Digite descrição completa.");
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Estoque06 estoque06){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque06.validandoString(nome)){
                return Produto06.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque06 estoque06){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque06.validandoString(categoria)){
                return Produto06.formatoNome(categoria);
            }
        }
    }

    private static final int MENOR_QUANTIDADE = 0;
    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < MENOR_QUANTIDADE){
                    System.out.println("Quantidade não pode ser menor que zero.");
                    continue;
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static final double MENOR_PRECO = 0;
    public static double validandoPrecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço Compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (precoCompra < MENOR_PRECO){
                    System.out.println("Preço compra não pode ser menor que zero.");
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
                System.out.print("Preço venda:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (precoVenda < precoCompra){
                    System.out.println("Preço de venda não pode ser menor que preco compra.");
                    continue;
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque06 estoque06){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque06.validandoString(fornecedor)){
                return Produto06.formatoNome(fornecedor);
            }
        }
    }

    public void listaProdutos(){
        if (produto06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto06s.forEach(System.out::println);
        }
    }

    public void pesquisaPorProduto(Scanner scanner, List<Produto06> produto06s){
        if (produto06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto06 produto6 = produto06s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto6 != null){
                    System.out.println("_____________________________________________");
                    System.out.println("Nome:"+produto6.getNome());
                    System.out.println("Categoria:"+produto6.getCategoria());
                    System.out.println("Quantidade:"+produto6.getQuantidade());
                    System.out.println("Preço Compra:R$"+produto6.getPrecoCompra());
                    System.out.println("Preço Venda:R$"+produto6.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto6.getFornecedor());
                    System.out.println("_____________________________________________");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirProdutos(Scanner scanner, List<Produto06> produto06s){
        if (produto06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto06 produto06 = produto06s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto06 != null){
                    produto06s.remove(produto06);
                    System.out.println("Produto excluido com sucesso.");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void retirandoProdutoVencido(){
        if (produto06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto06s.removeIf(produto06 -> produto06 instanceof ProdutosPereciveis06 &&
                    !((ProdutosPereciveis06)produto06).isValido());
            System.out.println("Produtos vencidos removidos.");
        }
    }

    public List<Produto06> getProduto06s() {
        return produto06s;
    }

    public void setProduto06s(List<Produto06> produto06s) {
        this.produto06s = produto06s;
    }
}
