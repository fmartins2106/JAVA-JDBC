package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque01 {
    private List<Produto01> produto01s;

    public Estoque01(){
        this.produto01s = new ArrayList<>();
    }

    public void addProdutoLista(Produto01 produto01){
        produto01s.add(produto01);
    }

    public static int validandoCodigo(Scanner scanner, List<Produto01> produto01s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo <=0 ){
                    System.out.println("Código deve ser maior que zero.");
                }else {
                    if (produto01s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                        System.out.println("Código já cadastrado.");
                    }else {
                        return codigo;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
                System.out.println("Campo nome não pode ser vazio ou conter caracteres.");
                continue;
            }
            return Produto01.formatoNome(nome);
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (validacaoString(categoria)){
                return categoria;
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor= scanner.nextLine().trim();
            if (validacaoString(fornecedor)){
                return fornecedor;
            }
        }
    }

    private static boolean validacaoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println("Campo não pode ser vazio ou conter caracteres.");
            return false;
        }
        return true;
    }

    public static double validandoPrecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço de compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (precoCompra < 0){
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
                System.out.print("Preço de venda:");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (validacaoPrecos(precoCompra, precoVenda)){
                    return precoVenda;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static boolean validacaoPrecos(double precoCompra,double precoVenda){
        if (precoCompra > precoVenda){
            System.out.println("Preço de compra não pode ser maior que preço de venda.");
            return false;
        }
        return true;
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < 0){
                    System.out.println("Quantidade não pode ser menor que zero.");
                    continue;
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor vazio.");
            }
        }
    }

    public void listaProdutos(){
        if (produto01s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto01s.forEach(System.out::println);
        }
    }

    public void excluirProduto(Scanner scanner){
        if (produto01s.isEmpty()){
            System.out.println("Lista vazia.");
        }else{
            try {
                System.out.print("Digite um código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto01 produto01 = produto01s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto01 != null){
                    produto01s.remove(produto01);
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }


    public void pesquisarPorCodigo(Scanner scanner){
        if (produto01s.isEmpty()){
            System.out.println("Lista vazia.");
        }else{
            try {
                System.out.print("Digite um código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto01 produto01 = produto01s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto01 != null){
                    System.out.println("__________________________________________________");
                    System.out.println("Nome:"+produto01.getNome());
                    System.out.println("Categoria:"+produto01.getCategoria());
                    System.out.println("Preço Compra:R$"+produto01.getPrecoCompra());
                    System.out.println("Preço venda:R$"+produto01.getPrecoVenda());
                    System.out.println("Quantidade:"+produto01.getQuantidade());
                    System.out.println("Fornecedor:"+produto01.getFornecedor());
                    System.out.println("_________________________________________________");
                }else {
                    System.out.println("Nenhum oroduto cadastrado com este código.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void retirandoProdutoVencido() {
        produto01s.removeIf(produto01 -> produto01 instanceof ProdutosPereciveis01 &&
                !((ProdutosPereciveis01) produto01).isValido());
        System.out.println("Produtos vencidos removidos.");
    }

    public List<Produto01> getProduto01s() {
        return produto01s;
    }

    public void setProduto01s(List<Produto01> produto01s) {
        this.produto01s = produto01s;
    }
}
