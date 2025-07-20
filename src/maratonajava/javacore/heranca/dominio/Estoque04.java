package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque04 {
    private List<Produto04> produto04s;

    public Estoque04(){
        this.produto04s = new ArrayList<>();
    }

    public void addProdutos(Produto04 produto04){
        produto04s.add(produto04);
    }

    public static int valindandoCodigo(Scanner scanner, List<Produto04> produto04s){
        while (true){
            try {
                System.out.print("Digite o código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Código não pode ser menor que 1.");
                    continue;
                }
                if (produto04s.stream().anyMatch(p-> p.getCodigo() == codigo)){
                    System.out.println("Código já cadastrado, tente outro.");
                    continue;
                }
                return codigo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner, Estoque04 estoque04){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque04.validandoFormatoString(nome)){
                return Produto04.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque04 estoque04){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque04.validandoFormatoString(categoria)){
                return Produto04.formatoNome(categoria);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < 0){
                    System.out.println("Digite um valor maior que zero.");
                }else {
                    return quantidade;
                }
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
                System.out.print("Preço de venda:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
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

    public static String validandoFornecedor(Scanner scanner, Estoque04 estoque04){
        while (true){
            System.out.print("Fornecedor:");
            String formecedor = scanner.nextLine().trim();
            if (estoque04.validandoFormatoString(formecedor)){
                return Produto04.formatoNome(formecedor);
            }
        }
    }

    private boolean validandoFormatoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo "+palavra+" não pode ser vazio ou conter caracteres. Digite descrição completa.");
            return false;
        }
        return true;
    }

    public void listarProdutos(){
        if (produto04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto04s.forEach(System.out::println);
        }
    }

    public void pesquisaPorCodigo(Scanner scanner){
        if (produto04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite um código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto04 produto4 = produto04s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto4 != null){
                    System.out.println("________________________________________");
                    System.out.println("Nome:"+produto4.getNome());
                    System.out.println("Categoria:"+produto4.getCategoria());
                    System.out.println("Preço Compra:R$"+produto4.getPrecoCompra());
                    System.out.println("Preço venda:R$"+produto4.getPrecoVenda());
                    System.out.println("Quantidade:R$"+produto4.getQuantidade());
                    System.out.println("Fornecedor:"+produto4.getFornecedor());
                    System.out.println("__________________________________________");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirProduto(Scanner scanner){
        if (produto04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto04 produto04 = produto04s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto04 !=null){
                    produto04s.remove(produto04);
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void retirarProdutoVencido(){
        if (produto04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto04s.removeIf(produto04 -> produto04 instanceof ProdutosPereciveis04 &&
                    !((ProdutosPereciveis04)produto04).isValido());
            System.out.println("Produto removido com sucesso.");
        }
    }

    public List<Produto04> getProduto04s() {
        return produto04s;
    }

    public void setProduto04s(List<Produto04> produto04s) {
        this.produto04s = produto04s;
    }
}
