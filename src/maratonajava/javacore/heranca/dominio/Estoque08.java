package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque08 {
    private List<Produto08> produto08s;

    public Estoque08(){
        this.produto08s = new ArrayList<>();

    }

    public void addProduto(Produto08 produto08){
        produto08s.add(produto08);
    }

    private static final int CODIGO_MINIMO=1;
    public static int validandoCodigo(Scanner scanner, List<Produto08> produto08s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < CODIGO_MINIMO){
                    System.out.println("Digite um código maior que 1");
                }else {
                    if (produto08s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                        System.out.println("Código já cadastrado, tente outro.");
                    }else {
                        return codigo;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um código válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner,Estoque08 estoque08){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine();
            if (estoque08.validandoString(nome)){
                return Produto08.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque08 estoque08){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine();
            if (estoque08.validandoString(categoria)){
                return Produto08.formatoNome(categoria);
            }
        }
    }

    private static final int QUANTIDADE_MINIMA=0;
    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < QUANTIDADE_MINIMA){
                    System.out.println("Quantidade não pode ser menor que zero.");
                    continue;
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static final double MENOR_PRECO_COMPRA = 0;
    public static double validandoPrecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço Compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (precoCompra < MENOR_PRECO_COMPRA){
                    System.out.println("Preço compra não pode ser menor que zero.");
                    continue;
                }
                return precoCompra;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoVenda(Scanner scanner,double precoCompra){
        while (true){
            try {
                System.out.print("Preço Compra:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (precoVenda < precoCompra){
                    System.out.println("Preço de venda não pode ser menor que preço compra.");
                    continue;
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }


    public static String validandoFornecedor(Scanner scanner, Estoque08 estoque08){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque08.validandoString(fornecedor)){
                return Produto08.formatoNome(fornecedor);
            }
        }
    }


    public boolean validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo "+palavra+ "Não pode ficar vazio ou conter caracteres.");
            return false;
        }
        return true;
    }

    public void listaProdutos(){
        if (produto08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto08s.forEach(System.out::println);
        }
    }


    public void pesquisaProduto(Scanner scanner, List<Produto08> produto08s){
        if (produto08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto08 produto08 = produto08s.stream().filter(p -> p.getCodigo() == codigo).findAny().orElse(null);
                if (produto08 != null){
                    System.out.println("_____________________________________");
                    System.out.println("Nome:"+produto08.getNome());
                    System.out.println("Categoria:"+produto08.getCategoria());
                    System.out.println("Quantidade:"+produto08.getQuantidade());
                    System.out.println("Preço de compra:R$"+produto08.getPrecoCompra());
                    System.out.println("Preço de venda:R$"+produto08.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto08.getFornecedor());
                    System.out.println("______________________________________");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirProduto(Scanner scanner, List<Produto08> produto08s){
        if (produto08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto08 produto8 = produto08s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto8 != null){
                    produto08s.remove(produto8);
                    System.out.println("Produto código:"+codigo+" removido com sucesso.");
                }else {
                    System.out.println("Código inexistente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void retirarProdutoVencido(Scanner scanner){
        if (produto08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto08s.removeIf(produto08 -> produto08 instanceof ProdutosPereciveis08 &&
                    !((ProdutosPereciveis08)produto08).validandoData());
            System.out.println("Produtos vencidos foram removidos com sucesso.");
        }
    }

    public List<Produto08> getProduto08s() {
        return produto08s;
    }

    public void setProduto08s(List<Produto08> produto08s) {
        this.produto08s = produto08s;
    }
}
