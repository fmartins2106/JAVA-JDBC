package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque11 {
    private List<Produto11> produto11s;

    public Estoque11(){
        this.produto11s = new ArrayList<>();
    }

    public boolean validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)*$")){
            System.out.println(Produto11.TEXTO_DESCRICAO);
            return false;
        }
        return true;
    }

    public void addProdutos(Produto11 produto11){
        produto11s.add(produto11);
    }

    public static int validandoCodigo(Scanner scanner, List<Produto11> produto11s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (produto11s.stream().anyMatch(p -> p.getCodigo() == codigo)){
                    System.out.println("Código já cadastrado, tente outro.");
                    continue;
                }
                return codigo;
            }catch (NumberFormatException e){
                System.out.println("Digite um código válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner, Estoque11 estoque11){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque11.validandoString(nome)){
                return Produto11.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque11 estoque11){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque11.validandoString(categoria)){
                return Produto11.formatoNome(categoria);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < Produto11.MENOR_QUANTIDADE){
                    System.out.println(Produto11.TEXTO_PARA_QUANTIDADE);
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
                if (precoCompra < Produto11.MENOR_PRECO_COMPRA){
                    System.out.println(Produto11.TEXTO_PARA_VALOR_COMPRA);
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
                    System.out.println(Produto11.TEXTO_PARA_VALOR_VENDA);
                    continue;
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque11 estoque11){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque11.validandoString(fornecedor)){
                return Produto11.formatoNome(fornecedor);
            }
        }
    }

    public void mostrarLista(){
        if (produto11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto11s.forEach(System.out::println);
        }
    }

    public Produto11 pesquisaNome(Scanner scanner){
        if (produto11s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim().toLowerCase();
            if (nome.isEmpty()){
                System.out.println("Nome não pode ser vazio.");
                return null;
            }
            Produto11 produto11 = produto11s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (produto11 != null){
                System.out.println("__________________________________");
                System.out.println("Nome:"+produto11.getNome());
                System.out.println("Categoria:"+produto11.getCodigo());
                System.out.println("Quantidade:"+produto11.getQuantidade());
                System.out.println("Preço compra:R$"+produto11.getPrecoCompra());
                System.out.println("Preço venda:R$"+produto11.getPrecoVenda());
                System.out.println("Fornecedor:"+produto11.getFornecedor());
                System.out.println("__________________________________");
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
            return produto11;
        }
    }

    public void excluindoProduto(Scanner scanner){
        if (produto11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Produto11 produto11 = pesquisaNome(scanner);
            if (produto11 != null){
                produto11s.remove(produto11);
                System.out.println("Registro removido com sucesso.");
            }else {
                System.out.println("Produto não encontrado.");
            }
        }
    }

    public void retirarProdutoVencido(){
        if (produto11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto11s.removeIf(produto11 -> produto11 instanceof ProdutosPereciveis11 &&
                    !((ProdutosPereciveis11)produto11).isValido());
            System.out.println("Produto vencido removido com sucesso.");
        }
    }

    public List<Produto11> getProduto11s() {
        return produto11s;
    }

    public void setProduto11s(List<Produto11> produto11s) {
        this.produto11s = produto11s;
    }

}
