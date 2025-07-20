package academy.devdojo.maratonajava.javacore.heranca.dominio;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque14 {
    private List<Produto14> produto14s;

    public Estoque14(){
        this.produto14s = new ArrayList<>();
    }

    public boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Produto14.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    public boolean validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto14.MENSAGEM_ERRO_CATEGORIA);
            return false;
        }
        return true;
    }

    public boolean validacaoCodigo(int codigo){
        if (codigo < Produto14.MENOR_CODIGO){
            System.out.println(Produto14.MENSAGEM_ERRO_CODIGO);
            return false;
        }
        return true;
    }

    public boolean validacaoQuantidade(int quantidade){
        if (quantidade < Produto14.MENOR_QUANTIDADE){
            System.out.println(Produto14.MENSAGEM_MENOR_QUANTIDADE);
            return false;
        }
        return true;
    }

    public boolean validacaoPrecoCompra(double precoCompra){
        if (precoCompra < Produto14.MENOR_PRECO_COMPRA){
            System.out.println(Produto14.MENSAGEM_ERRO_PRECO_COMPRA);
            return false;
        }
        return true;
    }

    public boolean validacaoPrecoVenda(double precoVenda, double precoCompra){
        if (precoVenda < precoCompra){
            System.out.println(Produto14.MENSAGEM_ERRO_PRECO_VENDA);
            return false;
        }
        return true;
    }

    public boolean validacaoFornecedor(String fornecedor){
        if ( fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto14.MENSAGEM_ERRO_FORNECEDOR);
            return false;
        }
        return true;
    }


    public static int validandoCodigo(Scanner scanner, Estoque14 estoque14, List<Produto14> produto14s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (estoque14.validacaoCodigo(codigo)){
                    boolean codigoExiste = produto14s.stream().anyMatch(p -> p.getCodigo() == codigo);
                    if (codigoExiste){
                        System.out.println("Código existente.");
                    }else {
                        return codigo;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner, Estoque14 estoque14){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque14.validacaoNome(nome)){
                return Produto14.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque14 estoque14){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque14.validacaoCategoria(categoria)){
                return Produto14.formatoNome(categoria);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner, Estoque14 estoque14){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (estoque14.validacaoQuantidade(quantidade)){
                    return quantidade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoCompra(Scanner scanner, Estoque14 estoque14){
        while (true){
            try {
                System.out.print("Preço compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (estoque14.validacaoPrecoCompra(precoCompra)){
                    return precoCompra;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoVenda(Scanner scanner,Estoque14 estoque14 ,double precoCompra){
        while (true){
            try {
                System.out.print("Preço venda:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (estoque14.validacaoPrecoVenda(precoVenda,precoCompra)){
                    return precoVenda;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validadoFornecedor(Scanner scanner, Estoque14 estoque14){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque14.validacaoFornecedor(fornecedor)){
                return Produto14.formatoNome(fornecedor);
            }
        }
    }

    public void addProdutos(Produto14 produto14){
        produto14s.add(produto14);
    }

    public void listaProdutos(){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto14s.forEach(System.out::println);
        }
    }

    public Produto14 pesquisaPorNome(Scanner scanner){
        Produto14 produto14;
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            produto14 = produto14s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (produto14 != null){
                System.out.println("__________________________________");
                System.out.println("Código:"+produto14.getCodigo());
                System.out.println("Nome:"+produto14.getNome());
                System.out.println("Categoria:"+produto14.getCategoria());
                System.out.println("Quantidade:"+produto14.getQuantidade());
                System.out.println("Preço compra:R$"+produto14.getPrecoCompra());
                System.out.println("Preço venda:R$"+produto14.getPrecoVenda());
                System.out.println("Fornecedor:"+produto14.getFornecedor());
                if (produto14 instanceof ProdutoComEstoqueMinimo14){
                    ProdutoComEstoqueMinimo14 produtoComEstoqueMinimo14 = (ProdutoComEstoqueMinimo14) produto14;
                    System.out.println("Estoque mínimo:"+produtoComEstoqueMinimo14.getEstoqueMinimo());
                }
                if (produto14 instanceof ProdutosPereciveis14){
                    ProdutosPereciveis14 produtosPereciveis14 = (ProdutosPereciveis14) produto14;
                    System.out.println("Data de válidade:"+produtosPereciveis14.getDataValidade());
                }
            }else {
                System.out.println("Nome não encontrado, tente novamente.");
                return null;
            }
        }
        return produto14;
    }

    public void excluindoProdutos(Scanner scanner){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Produto14 produto14 = pesquisaPorNome(scanner);
            produto14s.remove(produto14);
            System.out.println("Produtos removido com sucesso.");
        }
    }

    public void alterandoDados(Scanner scanner, Estoque14 estoque14){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Código:");
            int codigo = Integer.parseInt(scanner.nextLine());
            Produto14 produto14 = produto14s.stream().filter(p -> p.getCodigo()== codigo).findFirst().orElse(null);
            if (produto14 != null){
                System.out.println("_____________________________________");
                produto14.setNome(validandoNome(scanner,estoque14));
                produto14.setCategoria(validandoCategoria(scanner,estoque14));
                produto14.setQuantidade(validandoQuantidade(scanner,estoque14));
                produto14.setPrecoCompra(validandoPrecoCompra(scanner,estoque14));
                produto14.setPrecoVenda(validandoPrecoVenda(scanner,estoque14,produto14.getPrecoCompra()));
                produto14.setFornecedor(validadoFornecedor(scanner,estoque14));
                if (produto14 instanceof ProdutoComEstoqueMinimo14){
                    ProdutoComEstoqueMinimo14 produtoComEstoqueMinimo14 = (ProdutoComEstoqueMinimo14) produto14;
                    produtoComEstoqueMinimo14.setEstoqueMinimo(produtoComEstoqueMinimo14.validacaoEstoqueMinimo(scanner));
                }
                if (produto14 instanceof ProdutosPereciveis14){
                    ProdutosPereciveis14 produtosPereciveis14 = (ProdutosPereciveis14) produto14;
                    produtosPereciveis14.setDataValidade(produtosPereciveis14.validacaoDataValidade(scanner));
                }
            }else {
                System.out.println("Produto não encontrado.");
            }
        }
    }

    public void retirarProdutoVencido(){
        if (produto14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto14s.removeIf(produto14 -> produto14 instanceof ProdutosPereciveis14 &&
                    !((ProdutosPereciveis14)produto14).isValido());
            System.out.println("Produto vencido excluido com sucesso.");
        }
    }

    public List<Produto14> getProduto14s() {
        return produto14s;
    }

    public void setProduto14s(List<Produto14> produto14s) {
        this.produto14s = produto14s;
    }
}
