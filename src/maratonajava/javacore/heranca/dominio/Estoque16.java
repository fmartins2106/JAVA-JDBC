package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque16 {
    private List<Produto16> produto16s;

    public Estoque16(){
        this.produto16s = new ArrayList<>();
    }

    public boolean validacaoCodigo(int codigo){
        if (codigo < Produto16.MENOR_CODIGO){
            System.out.println(Produto16.MensagemValidacao.ERRO_CODIGO.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println(Produto16.MensagemValidacao.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto16.MensagemValidacao.ERRO_CATEGORIA.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoQuantidade(int quantidade){
        if (quantidade < Produto16.MENOR_QUANTIDADE){
            System.out.println(Produto16.MensagemValidacao.ERRO_QUANTIDADE.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoPrecoCompra(double precoCompra){
        if (precoCompra < Produto16.MENOR_PRECO_COMPRA){
            System.out.println(Produto16.MensagemValidacao.ERRO_PRECO_COMPRA.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoPrecoVenda(double precoVenda, double precoCompra){
        if (precoVenda < precoCompra){
            System.out.println(Produto16.MensagemValidacao.ERRO_PRECO_VENDA.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoFornecedor(String fornecedor){
        if (fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto16.MensagemValidacao.ERRO_FORNECEDOR.getDescricao());
            return false;
        }
        return true;
    }

    public static int validandoCodigo(Scanner scanner, Estoque16 estoque16){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (estoque16.validacaoCodigo(codigo)){
                    boolean codigoExiste = estoque16.produto16s.stream().anyMatch(p -> p.getCodigo()==codigo);
                    if (codigoExiste){
                        System.out.println("Código já cadastrado, tente novamente.");
                    }else {
                        return codigo;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um código válido.");
            }
        }
    }

    public static String validandoNome(Scanner scanne, Estoque16 estoque16){
        while (true){
            System.out.print("Nome:");
            String nome = scanne.nextLine().trim();
            if (estoque16.validacaoNome(nome)){
                return Produto16.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque16 estoque16){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque16.validacaoCategoria(categoria)){
                return Produto16.formatoNome(categoria);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner, Estoque16 estoque16){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (estoque16.validacaoQuantidade(quantidade)){
                    return quantidade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoCompra(Scanner scanner, Estoque16 estoque16){
        while (true){
            try {
                System.out.print("Preço Compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (estoque16.validacaoPrecoCompra(precoCompra)){
                    return precoCompra;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoVenda(Scanner scanner, Estoque16 estoque16, double precoCompra){
        while (true){
            try {
                System.out.print("Preço venda:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (estoque16.validacaoPrecoVenda(precoVenda,precoCompra)){
                    return precoVenda;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque16 estoque16){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque16.validacaoFornecedor(fornecedor)){
                return Produto16.formatoNome(fornecedor);
            }
        }
    }

    public void addProdutos(Produto16 produto16){
        produto16s.add(produto16);
    }

    public void listaProdutos(){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto16s.forEach(System.out::println);
        }
    }

    public Produto16 pesquisaProdutos(Scanner scanner, Estoque16 estoque16){
        Produto16 produto16 = null;
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            try {
                System.out.print("Código produto:");
                int codigo = Integer.parseInt(scanner.nextLine());
                produto16 = produto16s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto16 != null){
                    System.out.println("Nome:"+produto16.getNome());
                    System.out.println("Categoria:"+produto16.getCategoria());
                    System.out.println("Quantidade:"+produto16.getQuantidade());
                    System.out.println("Preço compra:R$"+produto16.getPrecoCompra());
                    System.out.println("Preço venda:R$"+produto16.getPrecoVenda());
                    if (produto16 instanceof ProdutoComEstoqueMinimo16){
                        ProdutoComEstoqueMinimo16 produtoComEstoqueMinimo16 = (ProdutoComEstoqueMinimo16) produto16;
                        System.out.println("Estoque mínimo:"+produtoComEstoqueMinimo16.getEstoqueMinimo());
                    }
                    if (produto16 instanceof ProdutosPereciveis16){
                        ProdutosPereciveis16 produtosPereciveis16 = (ProdutosPereciveis16) produto16;
                        System.out.println("Data de validade:"+produtosPereciveis16.getDataValidade());
                    }
                }else {
                    System.out.println("Código não encontrado.");
                    return null;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um código válido.");
            }
        }
        return produto16;
    }


    public void excluirDados(Scanner scanner, Estoque16 estoque16){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Produto16 produto16 = pesquisaProdutos(scanner,estoque16);
            produto16s.remove(produto16);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner, Estoque16 estoque16, double precoCompra){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Código:");
            int codigo = Integer.parseInt(scanner.nextLine());
            Produto16 produto16 = produto16s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
            if (produto16 != null){
                produto16.setNome(validandoNome(scanner,estoque16));
                produto16.setCategoria(validandoCategoria(scanner,estoque16));
                produto16.setQuantidade(validandoQuantidade(scanner, estoque16));
                produto16.setPrecoCompra(validandoPrecoCompra(scanner, estoque16));
                produto16.setPrecoVenda(validandoPrecoVenda(scanner,estoque16,precoCompra));
                produto16.setFornecedor(validandoFornecedor(scanner, estoque16));
                if (produto16 instanceof ProdutoComEstoqueMinimo16){
                    ProdutoComEstoqueMinimo16 produtoComEstoqueMinimo16 = (ProdutoComEstoqueMinimo16) produto16;
                    produtoComEstoqueMinimo16.setEstoqueMinimo(ProdutoComEstoqueMinimo16.validandoEstoqueMinimo(scanner));
                }
                if (produto16 instanceof  ProdutosPereciveis16){
                    ProdutosPereciveis16 produtosPereciveis16 = (ProdutosPereciveis16) produto16;
                    produtosPereciveis16.setDataValidade(ProdutosPereciveis16.validandoDataValidade(scanner));
                }
            }else {
                System.out.println("Código não encontrado.");
            }
        }
    }

    public void retirandoProdutosVencidos(){
        if (produto16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto16s.removeIf(produto16 -> produto16 instanceof ProdutosPereciveis16
            && ((ProdutosPereciveis16)produto16).isValido());
            System.out.println("Os produtos vencidos foram removidos com sucesso.");
        }
    }

    public List<Produto16> getProduto16s() {
        return produto16s;
    }

    public void setProduto16s(List<Produto16> produto16s) {
        this.produto16s = produto16s;
    }
}
