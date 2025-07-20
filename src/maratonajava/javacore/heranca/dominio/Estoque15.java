package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque15 {
    private List<Produto15> produto15s;

    public Estoque15(){
        this.produto15s = new ArrayList<>();
    }

    private boolean validancaoCodigo(int codigo){
        if (codigo < Produto15.CODIGO_MINIMO){
            System.out.println(Produto15.MENSAGEM_ERRO_CODIGO);
            return false;
        }
        return true;
    }

    private boolean validacaoCodigo(int codigo){
        if (codigo < Produto15.CODIGO_MINIMO){
            System.out.println(Produto15.MENSAGEM_ERRO_CODIGO);
            return false;
        }
        return true;
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println(Produto15.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoCategoria(String categoria){
        if (categoria ==  null || categoria.isEmpty() || !categoria.matches("[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto15.MENSAGEM_ERRO_CATEGORIA);
            return false;
        }
        return true;
    }

    private boolean validacaoQuantidade(int quantidade){
        if (quantidade < Produto15.QUANTIDADE_MINIMA){
            System.out.println(Produto15.MENSAGEM_ERRO_QUANTIDADE);
            return false;
        }
        return true;
    }

    private boolean validacaoPrecoCompra(double precoCompra){
        if (precoCompra < Produto15.PRECO_COMPRA_MINIMO){
            System.out.println(Produto15.MENSAGEM_ERRO_PRECO_COMPRA);
            return false;
        }
        return true;
    }

    private boolean validacaoPrecoVenda(double precoVenda, double precoCompra){
        if (precoVenda <  precoCompra){
            System.out.println(Produto15.MENSAGEM_ERRO_PRECO_VENDA);
            return false;
        }
        return true;
    }

    private boolean validacaoFornecedor(String fornecedor){
        if (fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto15.MENSAGEM_ERRO_FORNECEDOR);
            return false;
        }
        return true;
    }

    public static int validandoCodigo(Scanner scanner, Estoque15 estoque15){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (estoque15.validancaoCodigo(codigo)){
                    boolean codigoExiste = estoque15.getProduto15s().stream().anyMatch(p -> p.getCodigo() == codigo);
                    if (codigoExiste){
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

    public static String validandoNome(Scanner scanner,Estoque15 estoque15){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque15.validacaoNome(nome)){
                return Produto15.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque15 estoque15){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque15.validacaoCategoria(categoria)){
                return Produto15.formatoNome(categoria);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner, Estoque15 estoque15){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (estoque15.validacaoQuantidade(quantidade)){
                    return quantidade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static double validandoPrecoCompra(Scanner scanner, Estoque15 estoque15){
        while (true){
            try {
                System.out.print("Preço compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (estoque15.validacaoPrecoCompra(precoCompra)){
                    return precoCompra;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoVenda(Scanner scanner, Estoque15 estoque15, double precoCompra){
        while (true){
            try {
                System.out.print("Preço de venda:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (estoque15.validacaoPrecoVenda(precoVenda,precoCompra)){
                    return precoVenda;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque15 estoque15){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque15.validacaoFornecedor(fornecedor)){
                return Produto15.formatoNome(fornecedor);
            }
        }
    }

    public void addProdutos(Produto15 produto15){
        produto15s.add(produto15);
    }

    public void listaProdutos(){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto15s.forEach(System.out::println);
        }
    }

    public Produto15 pesquisaProduto(Scanner scanner, Estoque15 estoque15){
        Produto15 produto15 = null;
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                produto15 = produto15s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto15 != null){
                    System.out.println("Nome:"+produto15.getNome());
                    System.out.println("Categoria:"+produto15.getCategoria());
                    System.out.println("Quantidade:"+produto15.getQuantidade());
                    System.out.println("Preço Compra:R$"+produto15.getPrecoCompra());
                    System.out.println("Preço Venda:R$"+produto15.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto15.getFormecedor());
                    if (produto15 instanceof ProdutosComEstoqueMinimo15){
                        ProdutosComEstoqueMinimo15 produtosComEstoqueMinimo15 = (ProdutosComEstoqueMinimo15) produto15;
                        System.out.println("Estoque mínimo:"+produtosComEstoqueMinimo15.getEstoqueMinimo());
                    }
                    if (produto15 instanceof ProdutosPereciveis15){
                        ProdutosPereciveis15 produtosPereciveis15 = (ProdutosPereciveis15) produto15;
                        System.out.println("Data de validade:"+produtosPereciveis15.getDataValidade());
                    }
                }else {
                    System.out.println("Digite um valor válido.");
                    return null;
                }
            }catch (NumberFormatException e){
                System.out.println("Lista vazia.");
            }
        }
        return produto15;
    }

    public void excluirDadosProduto(Scanner scanner, Estoque15 estoque15){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Produto15 produto15 = pesquisaProduto(scanner,estoque15);
            produto15s.remove(produto15);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void excluirProdutosVencidos(){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto15s.removeIf(produto15 -> produto15 instanceof ProdutosPereciveis15 &&
                            ((ProdutosPereciveis15) produto15).isVencido());
            System.out.println("Produto(s) vencidos removidos com sucesso.");
        }
    }

    public void alterandoDados(Scanner scanner, Estoque15 estoque15, double precoCompra){
        if (produto15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto15 produto15 = produto15s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto15 != null){
                    produto15.setNome(validandoNome(scanner, estoque15));
                    produto15.setCategoria(validandoCategoria(scanner,estoque15));
                    produto15.setQuantidade(validandoQuantidade(scanner,estoque15));
                    produto15.setPrecoCompra(validandoPrecoCompra(scanner,estoque15));
                    produto15.setPrecoVenda(validandoPrecoVenda(scanner,estoque15,precoCompra));
                    produto15.setFormecedor(validandoFornecedor(scanner,estoque15));
                    if (produto15 instanceof ProdutosComEstoqueMinimo15){
                        ProdutosComEstoqueMinimo15 produtosComEstoqueMinimo15 = (ProdutosComEstoqueMinimo15) produto15;
                        ((ProdutosComEstoqueMinimo15) produto15).setEstoqueMinimo(ProdutosComEstoqueMinimo15.validandoEstoqueMinimo(scanner));
                    }
                    if (produto15 instanceof ProdutosPereciveis15){
                        ProdutosPereciveis15 produtosPereciveis15 = (ProdutosPereciveis15) produto15;
                        produtosPereciveis15.setDataValidade(ProdutosPereciveis15.validandoDataValidade(scanner));
                    }
                }else {
                    System.out.println("Código inválido, tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Dado inválido, novamente.");
            }
        }
    }

    public List<Produto15> getProduto15s() {
        return produto15s;
    }

    public void setProduto15s(List<Produto15> produto15s) {
        this.produto15s = produto15s;
    }
}
