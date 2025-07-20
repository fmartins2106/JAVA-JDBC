package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque05 {
    private List<Produto05> produto05s;

    public Estoque05(){
        this.produto05s = new ArrayList<>();
    }

    public void addProdutos(Produto05 produto05){
        produto05s.add(produto05);
    }

    public static int validandoCodigo(Scanner scanner, List<Produto05> produto05s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < 1){
                    System.out.println("Código não pode ser menor que 1.");
                }else {
                    if (produto05s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                        System.out.println("Código já utilizado no sistema, tente outro.");
                        continue;
                    }
                    return codigo;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner, Estoque05 estoque05){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque05.validandoStrings(nome)){
                return Produto05.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque05 estoque05){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque05.validandoStrings(categoria)){
                return Produto05.formatoNome(categoria);
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

    public static double validandoPrecoVenda(Scanner scanner,double precoCompra){
        while (true){
            try {
                System.out.print("Preço de venda:R$");
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


    public static String validandoFornecedor(Scanner scanner, Estoque05 estoque05){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque05.validandoStrings(fornecedor)){
                return Produto05.formatoNome(fornecedor);
            }
        }
    }



    private boolean validandoStrings(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo "+palavra+" não pode ser vazio, conter caracteres. Digite descrição completa.");
            return false;
        }
        return true;
    }

    public void listaDeProdutos(){
        if (produto05s.isEmpty()){
            System.out.println("lista vazia.");
        }else {
            produto05s.forEach(System.out::println);
        }
    }

    public void pesquisaPorProduto(Scanner scanner, List<Produto05> produto05s){
        if (produto05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto05 produto05 = produto05s.stream().filter(p-> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto05 != null){
                    System.out.println("_____________________________");
                    System.out.println("Nome:"+produto05.getNome());
                    System.out.println("Categoria:"+produto05.getCategoria());
                    System.out.println("Quantidade:"+produto05.getQuantidade());
                    System.out.println("Preço de compra:R$"+produto05.getPrecoCompra());
                    System.out.println("Preço de venda:R$"+produto05.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto05.getFornecedor());
                    System.out.println("______________________________");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirProduto(Scanner scanner, List<Produto05> produto05s){
        if (produto05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código do produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto05 produto05 = produto05s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto05 !=null){
                    produto05s.remove(produto05);
                }else {
                    System.out.println("Código não existente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void retirarProdutoVencido(){
        if (produto05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto05s.removeIf(produto05 -> produto05 instanceof ProdutosPereciveis05 &&
                    !((ProdutosPereciveis05)produto05).isValido());
            System.out.println("Produtos vencidos removidos.");
        }
    }

    public List<Produto05> getProduto05s() {
        return produto05s;
    }

    public void setProduto05s(List<Produto05> produto05s) {
        this.produto05s = produto05s;
    }

}
