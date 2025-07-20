package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque02 {
    private List<Produto02> produto02s;

    public Estoque02(){
        this.produto02s = new ArrayList<>();
    }

    public void addProduto(Produto02 produto02){
        produto02s.add(produto02);
    }

    public static int validandoCodigo(Scanner scanner, List<Produto02> produto02s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Código não pode ser menor que 1.");
                }else {
                    if (produto02s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                        System.out.println("Código já cadastrado. Tente outro código.");
                    }else {
                        return codigo;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner,Estoque02 estoque02){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque02.validandoString(nome)){
                return Produto02.formatoNome(nome);
            }else {
                System.out.println("Insira um nome válido.");
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque02 estoque02){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque02.validandoString(categoria)){
                return Produto02.formatoNome(categoria);
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

    public static double validandoprecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (precoCompra < 0){
                    System.out.println("Preço compra precisa ser maior que zero.");
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
                    continue;
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque02 estoque02){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque02.validandoString(fornecedor)){
                return Produto02.formatoNome(fornecedor);
            }
        }
    }

    private boolean validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo "+palavra+" não pode ser vazio ou conter caracteres.");
            return false;
        }
        return true;
    }

    public void listaProdutos(){
        if (produto02s.isEmpty()){
            System.out.println("lista vazia.");
        }else {
            produto02s.forEach(System.out::println);
        }
    }

    public void pesquisaProdutoCodigo(Scanner scanner){
        if (produto02s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto02 produto02 = produto02s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto02 != null){
                    System.out.println("_____________________________________________");
                    System.out.println("Nome:"+produto02.getNome());
                    System.out.println("Categoria:"+produto02.getCategoria());
                    System.out.println("Quantidade:"+produto02.getQuantidade());
                    System.out.println("Preço Compra:R$"+produto02.getPrecoCompra());
                    System.out.println("Preço venda:R$"+produto02.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto02.getFornecedor());
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluindoProduto(Scanner scanner, List<Produto02> produto02s){
        if (produto02s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto02 produto02 = produto02s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto02 != null){
                    produto02s.remove(produto02);
                }else {
                    System.out.println("Código não existente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void retirarProdutoPorCodigo(){
        produto02s.removeIf(produto02 -> produto02 instanceof ProdutosPereciveis02 &&
                !((ProdutosPereciveis02) produto02).isValido());
        System.out.println("Produtos vencidos removidos com sucesso.");
    }

    public List<Produto02> getProduto02s() {
        return produto02s;
    }

    public void setProduto02s(List<Produto02> produto02s) {
        this.produto02s = produto02s;
    }
}
