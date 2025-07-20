package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque03 {
    private List<Produto03> produto03s;

    public Estoque03(){
        this.produto03s = new ArrayList<>();
    }

    public void addProdutos(Produto03 produto03){
        produto03s.add(produto03);
    }

    public static int validandoCodigo(Scanner scanner, List<Produto03>produto03s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (produto03s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                    System.out.println("Código existente, tente outro.");
                    continue;
                }
                return codigo;
            }catch (NumberFormatException e){
                System.out.println("Digite um código válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner,Estoque03 estoque03){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque03.validandoString(nome)){
                return Produto03.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque03 estoque03){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine();
            if (estoque03.validandoString(categoria)){
                return Produto03.formatoNome(categoria);
            }
        }
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
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço compra:");
                int precoCompra = Integer.parseInt(scanner.nextLine());
                if (precoCompra < 0){
                    System.out.println("Insira um preço de compra maior que zero.");
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
                System.out.print("Preço venda:");
                int precoVenda = Integer.parseInt(scanner.nextLine());
                if (precoVenda < precoCompra){
                    System.out.println("Preço de venda não pode ser menor que preço de compra.");
                    continue;
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque03 estoque03){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque03.validandoString(fornecedor)){
                return Produto03.formatoNome(fornecedor);
            }
        }
    }

    public boolean validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo"+palavra+" não pode ser vazio ou conter caracteres. Digite descrição completa.");
            return false;
        }
        return true;
    }

    public void listaProdutos(){
        if (produto03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto03s.forEach(System.out::println);
        }
    }

    public void pesquisarPorCodigo(Scanner scanner){
        if (produto03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto03 produto03 = produto03s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto03 != null){
                    System.out.println("_______________________________");
                    System.out.println("Nome:"+produto03.getNome());
                    System.out.println("Categoria:"+produto03.getCategoria());
                    System.out.println("Quantidade:"+produto03.getQuantidade());
                    System.out.println("Preço compra:"+produto03.getPrecoCompra());
                    System.out.println("Preço venda:"+produto03.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto03.getFornecedor());
                    System.out.println("________________________________");
                }else {
                    System.out.println("Código não existente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirProduto(Scanner scanner){
        if (produto03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto03 produto03 = produto03s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto03!= null){
                    produto03s.remove(produto03);
                    System.out.println(">>Produto excluido do sistema com sucesso.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void retirarProdutoVencido(){
        produto03s.removeIf(produto03 -> produto03 instanceof ProdutosPereciveis03 &&
                !((ProdutosPereciveis03) produto03).isValido());
        System.out.println("Produtos vencidos removidos com sucesso.");
    }

    public List<Produto03> getProduto03s() {
        return produto03s;
    }

    public void setProduto03s(List<Produto03> produto03s) {
        this.produto03s = produto03s;
    }

}


