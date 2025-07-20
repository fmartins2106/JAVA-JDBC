package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque12 {
    private List<Produto12> produto12s;

    public Estoque12(){
        this.produto12s = new ArrayList<>();
    }

    public void addProdutosSistema(Produto12 produto12){
        produto12s.add(produto12);
    }

    public boolean validandoString(String palavra, String MENSAGEM_VALIDACAO){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)*$")){
            System.out.println(MENSAGEM_VALIDACAO);
            return false;
        }
        return true;
    }

    public static int validandoCodigo(Scanner scanner,List<Produto12> produto12s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < Produto12.MENOR_CODIGO){
                    System.out.println(Produto12.MENSAGEM_MENOR_CODIGO);
                }else {
                    if (produto12s.stream().anyMatch(p -> p.getCodigo()==codigo)){
                        System.out.println("Código já cadastrado, tente novamente.");
                    }else {
                        return codigo;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner, Estoque12 estoque12){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque12.validandoString(nome, Produto12.MENSAGEM_NOME_INVALIDO)){
                return Produto12.formatoNome(nome);
            }else {
                System.out.println(Produto12.MENSAGEM_NOME_INVALIDO);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque12 estoque12){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque12.validandoString(categoria,Produto12.MENSAGEM_CATEGORIA_INVALIDA)){
                return Produto12.formatoNome(categoria);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < Produto12.QUANTIDADE_MINIMA){
                    System.out.println(Produto12.MENSAGEM_QUANTIDADE_INVALIDA);
                    continue;
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }

    public static double validandoPrecoCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço Compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (precoCompra < Produto12.MENOR_PRECO_COMPRA){
                    System.out.println(Produto12.MENSAGEM_PRECO_COMPRA_INVALIDO);
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
                    System.out.println(Produto12.MENSAGEM_PRECO_VENDA_INVALIDO);
                    continue;
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String fornecedor(Scanner scanner, Estoque12 estoque12){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque12.validandoString(fornecedor, Produto12.MENSAGEM_FORNECEDOR_INVALIDO)){
                return Produto12.formatoNome(fornecedor);
            }
        }
    }

    public void listarProdutos(){
        if (produto12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto12s.forEach(System.out::println);
        }
    }

    public Produto12 pesquisaProduto(Scanner scanner, Estoque12 estoque12){
        Produto12 produto12 = null;
        if (produto12s.isEmpty()){
            System.out.println("Lista está vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque12.validandoString(nome, Produto12.MENSAGEM_NOME_INVALIDO)){
                produto12 = produto12s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
                if (produto12 != null){
                    System.out.println("__________________________");
                    System.out.println("Código:"+produto12.getCodigo());
                    System.out.println("Nome:"+produto12.getNome());
                    System.out.println("Categoria:"+produto12.getCategoria());
                    System.out.println("Quantidade:"+produto12.getQuantidade());
                    System.out.println("Preço Compra:R$"+produto12.getPrecoCompra());
                    System.out.println("Preço venda:R$"+produto12.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto12.getFornecedor());
                    System.out.println("__________________________");
                }else {
                    System.out.println("Nome não encontrado.");
                    return null;
                }
            }else {
                return null;
            }
        }
        return produto12;
    }

    public void excluirProdutos(Scanner scanner){
        if (produto12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Produto12 produto12 = pesquisaProduto(scanner,this);
            if (produto12 != null){
                produto12s.remove(produto12);
                System.out.println("Dados excluido com sucesso.");
            }else {
                System.out.println("Produto não encontrado.");
            }
        }
    }

    public void removendoProdutoVencido(){
        if (produto12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto12s.removeIf(produto12 -> produto12 instanceof ProdutosPereciveis12 &&
                    !((ProdutosPereciveis12)produto12).isValido());
            System.out.println("Produtos vencidos removidos com sucesso.");
        }
    }

    public List<Produto12> getProduto12s() {
        return produto12s;
    }

    public void setProduto12s(List<Produto12> produto12s) {
        this.produto12s = produto12s;
    }
}
