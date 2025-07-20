package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque09 {
    private List<Produto09> produto09s;

    public Estoque09(){
        this.produto09s = new ArrayList<>();
    }

    public void addProdutos(Produto09 produto09){
        produto09s.add(produto09);
    }

    public static final int CODIGO_MINIMO=1;
    public static int validandoCodigo(Scanner scanner, List<Produto09> produto09s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < CODIGO_MINIMO){
                    System.out.println("Digite um código maior que 1.");
                    continue;
                }
                if (produto09s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                    System.out.println("Código já cadastrado, tente outro.");
                    continue;
                }
                return codigo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner, Estoque09 estoque09){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque09.validandoString(nome)){
                return Produto09.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque09 estoque09){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque09.validandoString(categoria)){
                return  Produto09.formatoNome(categoria);
            }
        }
    }

    public static final int QUANTIDADE_MINIMO = 0;
    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < QUANTIDADE_MINIMO){
                    System.out.println("Quantidade não pode ser menor que zero.");
                    continue;
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Digige um valor válido.");
            }
        }
    }

    public static final double PRECO_COMPRA_MINIMO = 0;
    public static double validandoPrecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço de compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (precoCompra < PRECO_COMPRA_MINIMO){
                    System.out.println("Preço de compra não pode ser menor que zero.");
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
                    System.out.println("Preço de venda não pode ser menor que o preço de compra.");
                    continue;
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque09 estoque09){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine();
            if (estoque09.validandoString(fornecedor)){
                return Produto09.formatoNome(fornecedor);
            }
        }
    }

    public boolean validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo "+palavra+" não pode ser vazio ou conter caracteres. Digite descrição completa.");
            return false;
        }
        return true;
    }

    public void validandoProduto(){
        if (produto09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto09s.forEach(System.out::println);
        }
    }

    public void pesquisaCodigo(Scanner scanner){
        if (produto09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto09 produto09 = produto09s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto09 != null){
                    System.out.println("_______________________________________________");
                    System.out.println("Nome:"+produto09.getNome());
                    System.out.println("Categoria:"+produto09.getCategoria());
                    System.out.println("Quantidade:"+produto09.getQuantidade());
                    System.out.println("Fornecedor:"+produto09.getFornecedor());
                    System.out.println("Preço Compra:R$"+produto09.getPrecoCompra());
                    System.out.println("Preço venda:R$"+produto09.getPrecoVenda());
                    System.out.println("_______________________________________________");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirProduto(Scanner scanner){
        if (produto09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner,this);
            Produto09 produto09 = produto09s.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
            produto09s.remove(produto09);
            System.out.println("Produto removido com sucesso....");
        }
    }

    public void retirarProdutoVencido(){
        if (produto09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto09s.removeIf(produto09 -> produto09 instanceof ProdutosPereciveis09 &&
                    !((ProdutosPereciveis09)produto09).isValido());
            System.out.println("Produto vencido removido com sucesso.");
        }
    }

    public List<Produto09> getProduto09s() {
        return produto09s;
    }

    public void setProduto09s(List<Produto09> produto09s) {
        this.produto09s = produto09s;
    }
}
