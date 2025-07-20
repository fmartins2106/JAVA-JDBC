package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque07 {
    private List<Produto07> produto07s;

    public Estoque07(){
        this.produto07s = new ArrayList<>();
    }

    public void addProdutos(Produto07 produto07){
        produto07s.add(produto07);
    }

    private static final int MINIMO_CODIGO = 1;
    public static int validandoCodigo(Scanner scanner, List<Produto07>produto07s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < MINIMO_CODIGO){
                    System.out.println("Código não pode ser menor que um.");
                    continue;
                }
                if (produto07s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                    System.out.println("Código já existente, digite outro código.");
                }else {
                    return codigo;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um código válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner,Estoque07 estoque07){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque07.validandoString(nome)){
                return Produto07.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque07 estoque07){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque07.validandoString(categoria)){
                return Produto07.formatoNome(categoria);
            }
        }
    }
    private static final int QUANTIDADE_MINIMA = 0;
    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < QUANTIDADE_MINIMA){
                    System.out.println("Quantidade não pode ser menor que 0.");
                    continue;
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Quantidade não pode ser menor que zero.");
            }
        }
    }

    private static final double PRECO_COMPRA = 0;
    public static double validandoPrecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço de compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (precoCompra < PRECO_COMPRA){
                    System.out.println("Preço de compra não pode ser menor que 0;");
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
                System.out.print("Preço de Venda:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (precoVenda < precoCompra){
                    System.out.println("Preço de venda não pode ser menor que preço de compra.");
                    continue;
                }
                return precoCompra;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque07 estoque07){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor= scanner.nextLine().trim();
            if (estoque07.validandoString(fornecedor)){
                return Produto07.formatoNome(fornecedor);
            }
        }
    }

    private boolean validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo "+palavra+" não pode ficar vazio ou conter caracteres.");
            return false;
        }
        return true;
    }

    public void listarProdutos(){
        if (produto07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto07s.forEach(System.out::println);
        }
    }

    public void pesquisaProdutoCodigo(Scanner scanner){
        if (produto07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto07 produto07 = produto07s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto07 !=null){
                    System.out.println("__________________________________________");
                    System.out.println("Nome:"+produto07.getNome());
                    System.out.println("Categoria:"+produto07.getCategoria());
                    System.out.println("Quantidade:"+produto07.getQuantidade());
                    System.out.println("Preço compra:R$"+produto07.getPrecoCompra());
                    System.out.println("Preço venda:R$"+produto07.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto07.getFornecedor());
                    System.out.println("__________________________________________");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }

    public void retirarProdutoVencido(){
        if (produto07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto07s.removeIf(produto07 -> produto07 instanceof ProdutosPereciveis07 &&
                    !((ProdutosPereciveis07)produto07).isValido());
            System.out.println("Produtos vencidos removidos.");
        }
    }

    public void excluirProduto(Scanner scanner ){
        if (produto07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto07 produto = produto07s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto !=null){
                    produto07s.remove(produto);
                    System.out.println("Produto código: "+codigo+" removido com sucesso.");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public List<Produto07> getProduto07s() {
        return produto07s;
    }

    public void setProduto07s(List<Produto07> produto07s) {
        this.produto07s = produto07s;
    }
}
