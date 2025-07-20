package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque17 {
    private List<Produto17>produto17s;

    public Estoque17(){
        this.produto17s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println(Produto17.MensagemValidacaoProduto17.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCodigo(int codigo){
        if (codigo < Produto17.CODIGO_MINIMO){
            System.out.println(Produto17.MensagemValidacaoProduto17.ERRO_CODIGO.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto17.MensagemValidacaoProduto17.ERR0_CATEGORIA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoQuantidade(int quantidade){
        if (quantidade < Produto17.QUANTIDADE_MINIMA){
            System.out.println(Produto17.MensagemValidacaoProduto17.ERRO_QUANTIDADE.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoPrecoCompra(double precoCompra){
        if (precoCompra < Produto17.PRECO_COMPRA){
            System.out.println(Produto17.MensagemValidacaoProduto17.ERRO_PRECO_COMPRA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoPrecoVenda(double precoVenda, double precoCompra){
        if (precoVenda < precoCompra){
            System.out.println(Produto17.MensagemValidacaoProduto17.ERRO_PRECO_VENDA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoFornecedor(String fornecedor){
        if (fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Produto17.MensagemValidacaoProduto17.ERRO_FORNECEDOR.getDescricao());
            return false;
        }
        return true;
    }

    public static int validandoCodigo(Scanner scanner, Estoque17 estoque17){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                boolean codigoExiste = false;
                if (estoque17.getProduto17s().stream().anyMatch(p -> p.getCodigo() == codigo)){
                    codigoExiste = true;
                    System.out.println("Código já cadastrado, tem outro código.");
                    continue;
                }
                if (estoque17.validacaoCodigo(codigo)){
                    return codigo;
                }
            }catch (NumberFormatException e){
                System.out.println("Código inválido.");
            }
        }
    }

    public static String validandoNome(Scanner scanner, Estoque17 estoque17){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (estoque17.validacaoNome(nome)){
                return Produto17.formatoNome(nome);
            }
        }
    }

    public static String validandoCategoria(Scanner scanner, Estoque17 estoque17){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (estoque17.validacaoCategoria(categoria)){
                return Produto17.formatoNome(categoria);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner, Estoque17  estoque17){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (estoque17.validacaoQuantidade(quantidade)){
                    return quantidade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoCompra(Scanner scanner, Estoque17 estoque17){
        while (true){
            try {
                System.out.print("Preço compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (estoque17.validacaoPrecoCompra(precoCompra)){
                    return precoCompra;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoVenda(Scanner scanner, Estoque17 estoque17, double precoCompra){
        while (true){
            try {
                System.out.print("Preço de venda:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (estoque17.validacaoPrecoVenda(precoVenda,precoCompra)){
                    return precoVenda;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoFornecedor(Scanner scanner, Estoque17 estoque17){
        while (true){
            System.out.print("Fornecedor:");
            String fornecedor = scanner.nextLine().trim();
            if (estoque17.validacaoFornecedor(fornecedor)){
                return Produto17.formatoNome(fornecedor);
            }
        }
    }

    public void addProdutos(Produto17 produto17){
        produto17s.add(produto17);
    }

    public void listaProdutos(){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto17s.forEach(System.out::println);
        }
    }

    public Produto17 pesquisaPorCodigo(Scanner scanner, Estoque17 estoque17){
        Produto17 produto17 = null;
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                produto17 = produto17s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto17 != null){
                    System.out.println("Nome:"+produto17.getNome());
                    System.out.println("Categoria:"+produto17.getCategoria());
                    System.out.println("Quantidade:"+produto17.getQuantidade());
                    System.out.println("Preço compra:R$"+produto17.getPrecoCompra());
                    System.out.println("Preço venda:R$"+produto17.getPrecoVenda());
                    System.out.println("Fornecedor:"+produto17.getFornecedor());
                    if (produto17 instanceof ProdutoComEstoqueMinimo17){
                        ProdutoComEstoqueMinimo17 produtoComEstoqueMinimo17 = (ProdutoComEstoqueMinimo17) produto17;
                        System.out.println("Estoque mínimo:"+produtoComEstoqueMinimo17.getEstoqueMinimo());
                    }
                    if (produto17 instanceof ProdutosPereciveis17){
                        ProdutosPereciveis17 produtosPereciveis17 = (ProdutosPereciveis17) produto17;
                        System.out.println("Data validade:"+produtosPereciveis17.getDataValidade());
                    }
                }else {
                    System.out.println("Produto não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
                return null;
            }
        }
        return produto17;
    }

    public void excluirDados(Scanner scanner, Estoque17 estoque17){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Produto17 produto17 = pesquisaPorCodigo(scanner,estoque17);
            produto17s.remove(produto17);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner, Estoque17 estoque17){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Código:");
            int codigo = Integer.parseInt(scanner.nextLine());
            Produto17 produto17 = produto17s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
            if (produto17 != null){
                produto17.setNome(validandoNome(scanner,estoque17));
                produto17.setCategoria(validandoCategoria(scanner,estoque17));
                produto17.setQuantidade(validandoQuantidade(scanner,estoque17));
                produto17.setPrecoCompra(validandoPrecoCompra(scanner,estoque17));
                produto17.setPrecoVenda(validandoPrecoVenda(scanner,estoque17, produto17.getPrecoCompra()));
                produto17.setFornecedor(validandoFornecedor(scanner,estoque17));
                if (produto17 instanceof ProdutoComEstoqueMinimo17){
                    ProdutoComEstoqueMinimo17 produtoComEstoqueMinimo17 = (ProdutoComEstoqueMinimo17) produto17;
                    produtoComEstoqueMinimo17.setEstoqueMinimo(ProdutoComEstoqueMinimo17.validandoEstoqueMinimo(scanner));
                }
                if (produto17 instanceof ProdutosPereciveis17){
                    ProdutosPereciveis17 produtosPereciveis17 = (ProdutosPereciveis17) produto17;
                    produtosPereciveis17.setDataValidade(ProdutosPereciveis17.validandoDataDeValidade(scanner));
                }
            }else {
                System.out.println("Código não encontrado.");
            }
        }
    }

    public void excluirProdutosVencidos(){
        if (produto17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto17s.removeIf(produto17 -> produto17 instanceof ProdutosPereciveis17 &&
                    !((ProdutosPereciveis17)produto17).isValido());
            System.out.println("Produto(s) vendidos excluidos com sucesso.");
        }
    }

//    public void removerProdutoVencido(){
//        if (produto17s.isEmpty()){
//            System.out.println("Nenhum produto foi cadastrado.");
//            return;
//        }
//        produto17s.removeIf(produto17 -> produto17 instanceof ProdutosPereciveis17 &&
//                !((ProdutosPereciveis17) produto17).isValido());
//        System.out.println("Produto removido com sucesso.");
//    }

    public List<Produto17> getProduto17s() {
        return produto17s;
    }

    public void setProduto17s(List<Produto17> produto17s) {
        this.produto17s = produto17s;
    }
}
