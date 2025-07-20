package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque24 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase24> produtoBase24s;

    public Estoque24(){
        this.produtoBase24s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase24.validacaoNome(nome);
                return ProdutoBase24.formatoString(nome);
            }catch (NomeProdutoBase24 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase24.validacaoPreco(preco);
                return preco;
            }catch (PrecoProdutoBase24 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase24.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válidao.");
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase24.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (EstoqueMinimoProdutoBase24 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Digite a data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel24.validandoVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataValidadePerecivel24 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis24.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (MesesGarantia24 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis24.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido24 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase24 produtoBase24){
        produtoBase24s.add(produtoBase24);
    }

    public void listarProdutos(){
        if (produtoBase24s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase24s.forEach(System.out::println);
    }

    public void listarProdutos(List<ProdutoBase24> produtoBase24s){
        if (produtoBase24s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase24s.forEach(System.out::println);
    }

    public Optional<ProdutoBase24> pesquisaPorNome(String nome){
        if (produtoBase24s.isEmpty()){
            System.out.println("Nenhum produto encontrado.");
            return Optional.empty();
        }
        return produtoBase24s.stream().filter(produtoBase24 -> produtoBase24.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase24s.removeIf(produtoBase24 -> produtoBase24.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void exibirPesquisaPorNome(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            System.out.println(pesquisaPorNome(nome).get());
            return;
        }
        System.out.println("Nome não encontrado.");
    }

    public void listarProdutosVencidos(){
        if (produtoBase24s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase24> produtosVencidos = new ArrayList<>();
        boolean produtoVencidoEncontrado = false;
        for (ProdutoBase24 produtoBase24 : produtoBase24s) {
            if (produtoBase24 instanceof  ProdutoPerecivel24){
                ProdutoPerecivel24 produtoPerecivel24 = (ProdutoPerecivel24) produtoBase24;
                if (produtoPerecivel24.estaVencido()){
                    produtosVencidos.add(produtoPerecivel24);
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

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase24> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase24 produtoBase24 : produtoBase24s) {
            if (produtoBase24.getPreco() >= precoMinimo && produtoBase24.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase24);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        listarProdutos(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase24> getProdutoBase24s() {
        return produtoBase24s;
    }
}
