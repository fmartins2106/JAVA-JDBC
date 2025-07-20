package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque25 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase25> produtoBase25s;

    public Estoque25(){
        this.produtoBase25s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase25.validacaoNome(nome);
                return ProdutoBase25.formatoString(nome);
            }catch (NomeProdutoBase25 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase25.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (PrecoProdutoBase25 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase25.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (QuantidadeProdutoBase25 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase25.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir estoque mínimo.");
            }catch (EstoqueMinimoProdutoBase25 e){
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
                LocalDate validade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel25.validacaoValidade(validade);
                return validade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data no formato DD/MM/AAAA.");
            }catch (DataValidadePerecivel25 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Garantia:");
                int garantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis25.validacaoMesesGarantia(garantia);
                return garantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para definir garantia.");
            }catch (MesesGarantia25 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis25.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido25 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase25 produtoBase25){
        produtoBase25s.add(produtoBase25);
    }

    public void listarProdutosSistema(){
        if (produtoBase25s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase25s.forEach(System.out::println);
    }

    public void listarProdutosSistema(List<ProdutoBase25> produtoBase25s){
        if (produtoBase25s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase25s.forEach(System.out::println);
    }

    public Optional<ProdutoBase25> pesquisaPorNome(String nome){
        if (produtoBase25s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return Optional.empty();
        }
        return produtoBase25s.stream().filter(produtoBase25 -> produtoBase25.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void exibirPesquisaPorNome(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            System.out.println(pesquisaPorNome(nome).get());
            return;
        }
        System.out.println("Nenhum nome foi encontrado.");
    }

    public void excluirProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase25s.removeIf(produtoBase25 -> produtoBase25.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto excluido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    public void listarProdutosVencidos(){
        if (produtoBase25s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase25> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase25 produtoBase25 : produtoBase25s) {
            if (produtoBase25 instanceof ProdutoPerecivel25){
                ProdutoPerecivel25 produtoPerecivel25 = (ProdutoPerecivel25) produtoBase25;
                if (produtoPerecivel25.estaVencido()){
                    produtosVencidos.add(produtoPerecivel25);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosSistema(produtosVencidos);
    }

    public void listarProdutosPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase25> produtosPorFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase25 produtoBase25 : produtoBase25s) {
            if (produtoBase25.getPreco() >= precoMinimo && produtoBase25.getPreco() <= precoMaximo){
                produtosPorFaixaDePreco.add(produtoBase25);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosSistema(produtosPorFaixaDePreco);
    }

    public List<ProdutoBase25> getProdutoBase25s() {
        return produtoBase25s;
    }
}
