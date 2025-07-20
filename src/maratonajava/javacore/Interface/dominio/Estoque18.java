package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque18 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase18> produtoBase18s;

    public Estoque18(){
        this.produtoBase18s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase18.validacaoNome(nome);
                return ProdutoBase18.formatoString(nome);
            }catch (NomeProdutoBase18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validacaoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase18.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase18.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (QuantidadeProdutoBase18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase18.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (EstoqueMinimoProdutoBase18 e){
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
                ProdutoPerecivel18.validacaoDataVencimento(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataValidadePerecivel18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis18.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }catch (MesesGarantia18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis18.validacaoCategoria(categoria);
                return ProdutoBase18.formatoString(categoria);
            }catch (CategoriaProdutoInvalido18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase18 produtoBase18){
        produtoBase18s.add(produtoBase18);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase18s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase18s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase18> produtoBase18s){
        if (produtoBase18s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase18s.forEach(System.out::println);
    }

    public Optional<ProdutoBase18> pesquisaPorNome(String nome){
        if (produtoBase18s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase18s.stream().filter(produtoBase18 -> produtoBase18.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirDadosProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase18s.removeIf(produtoBase18 -> produtoBase18.getNome().equalsIgnoreCase(nome));
            return;
        }
        System.out.println("Nome não encontrado.");
    }

    public void listarProdutosVencidos(){
        if (produtoBase18s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase18> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase18 produtoBase18 : produtoBase18s) {
            if (produtoBase18 instanceof ProdutoPerecivel18){
                ProdutoPerecivel18 produtoPerecivel18 = (ProdutoPerecivel18) produtoBase18;
                if (produtoPerecivel18.estaVencido()){
                    produtosVencidos.add(produtoBase18);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosVencidos);
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase18> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase18 produtoBase18 : produtoBase18s) {
            if (produtoBase18.getPreco() >= precoMinimo && produtoBase18.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase18);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase18> getProdutoBase18s() {
        return produtoBase18s;
    }
}
