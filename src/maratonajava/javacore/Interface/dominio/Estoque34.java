package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque34 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase34> produtoBase34s;

    public Estoque34(){
        this.produtoBase34s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase34.validacaoNome(nome);
                return ProdutoBase34.formatoString(nome);
            }catch (NomeProdutoBase34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase34.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.print("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase34.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para quantidade.");
            }catch (QuantidadeProdutoBase34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase34.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (EstoqueMinimoProdutoBase34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel34.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato DD/MM/AAAA.");
            }catch (DataValidadePerecivel34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis34.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir garantia.");
            }catch (MesesGarantia34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis34.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase34 produtoBase34){
        produtoBase34s.add(produtoBase34);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutos(){
        if (produtoBase34s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase34s.forEach(System.out::println);
    }

    public void listarProdutos(List<ProdutoBase34> produtoBase34s){
        if (produtoBase34s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase34s.forEach(System.out::println);
    }

    public void listarProdutosVencidos(){
        if (produtoBase34s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase34> produtosVencidos = new ArrayList<>();
        boolean produtoVencidoEncontrado = false;
        for (ProdutoBase34 produtoBase34 : produtoBase34s) {
            if (produtoBase34s instanceof ProdutoPerecivel34){
                ProdutoPerecivel34 produtoPerecivel34 = (ProdutoPerecivel34) produtoBase34;
                if (produtoPerecivel34.estaVencido()){
                    produtosVencidos.add(produtoPerecivel34);
                    produtoVencidoEncontrado = true;
                }
            }
        }
        if (!produtoVencidoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutos(produtosVencidos);
    }

    public Optional<ProdutoBase34> pesquisaPorNome(String nome){
        if (produtoBase34s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase34s.stream().filter(produtoBase34 -> produtoBase34.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirDadosProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase34s.removeIf(produtoBase34 -> produtoBase34.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido do sistema.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

//    public void excluirProduto(String nome){
//        if (pesquisaPorNome(nome).isPresent()){
//            produtoBase34s.removeIf(produtoBase34 -> produtoBase34.getNome().equalsIgnoreCase(nome));
//            System.out.println("Produto removido com sucesso.");
//            return;
//        }
//        System.out.println("Produto não encontrado.");
//    }

    public void exibirPesquisaPorNome(String nome){
        pesquisaPorNome(nome).ifPresentOrElse(System.out::println, () ->
                System.out.println("Nenhum produto foi encontrado."));
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase34> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase34 produtoBase34 : produtoBase34s) {
            if (produtoBase34.getPreco() >= precoMinimo && produtoBase34.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase34);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Produto não encontrado.");
            return;
        }
        listarProdutos(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase34> getProdutoBase34s() {
        return produtoBase34s;
    }
}
