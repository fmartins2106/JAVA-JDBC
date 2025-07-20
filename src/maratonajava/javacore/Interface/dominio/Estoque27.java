package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque27 {
    private static Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase27> produtoBase27s;

    public Estoque27(){
        this.produtoBase27s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase27.validacaoNome(nome);
                return ProdutoBase27.formatoString(nome);
            }catch (NomeProduto27 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase27.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase27 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase27.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para quantidade.");
            }catch (QuantidadeProdutoBase27 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase27.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase27 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validacaoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel27.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato DD/MM/AAAA.");
            }catch (DataValidadePerecivel27 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoGarantia(){
        while (true){
            try {
                System.out.print("Garantia:");
                int garantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis27.validacaoMeseGarantia(garantia);
                return garantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia27 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis27.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido27 e){
                System.out.println(e.getMessage());
            }
        }
    }


    public void addProdutoSistema(ProdutoBase27 produtoBase27){
        produtoBase27s.add(produtoBase27);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutos(){
        if (produtoBase27s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase27s.forEach(System.out::println);
    }

    public void listarProdutos(List<ProdutoBase27> produtoBase27s){
        if (produtoBase27s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase27s.forEach(System.out::println);
    }

    public void listarProdutosVencidos(){
        if (produtoBase27s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase27> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado  = false;
        for (ProdutoBase27 produtoBase27 : produtoBase27s) {
            if (produtoBase27  instanceof ProdutoPerecivel27){
                ProdutoPerecivel27 produtoPerecivel27 = (ProdutoPerecivel27) produtoBase27;
                if (produtoPerecivel27.estaVencido()){
                    produtosVencidos.add(produtoPerecivel27);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Erro. Nenhum produto foi encontrado.");
            return;
        }
        listarProdutos(produtosVencidos);
    }

    public Optional<ProdutoBase27> pesquisaPorNome(String nome){
        if (produtoBase27s.isEmpty()){
            System.out.println("Nenhum produto encontrado.");
            return Optional.empty();
        }
        return produtoBase27s.stream().filter(produtoBase27 -> produtoBase27.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void exibirPesquisaPorNome(String nome){
        pesquisaPorNome(nome).ifPresentOrElse(System.out::println,
                () -> System.out.println("Produto não encontrado."));
    }

    public void excluirDadosProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase27s.removeIf(produtoBase27 -> produtoBase27.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removidos com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase27> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase27 produtoBase27 : produtoBase27s) {
            if (produtoBase27.getPreco() >= precoMinimo && produtoBase27.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase27);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutos(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase27> getProdutoBase27s() {
        return produtoBase27s;
    }
}
