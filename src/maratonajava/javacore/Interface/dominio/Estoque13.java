package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque13 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase13> produtoBase13s;

    public Estoque13(){
        this.produtoBase13s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase13.validacaoNome(nome);
                return ProdutoBase13.formatoString(nome);
            }catch (NomeProdutoBase13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase13.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase13.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (QuantidadeProdutoBase13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase13.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase13 e){
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
                ProdutoPerecivel13.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida.");
            }catch (DataValidade13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis13.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Número inválido.");
            }catch (MesesGarantia13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis13.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase13 produtoBase13){
        produtoBase13s.add(produtoBase13);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutos(){
        if (produtoBase13s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase13s.forEach(System.out::println);
    }

    public void listarProdutos(List<ProdutoBase13> produtoBase13s){
        if (produtoBase13s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase13s.forEach(System.out::println);
    }
    
    public Optional<ProdutoBase13> pesquisaPorNome(String nome){
        if (produtoBase13s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase13s.stream().filter(produtoBase13 -> produtoBase13.getNome().equalsIgnoreCase(nome)).findFirst();
    }
    
    public void listarProdutoVencidos(){
        if (produtoBase13s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        boolean produtoEncontrado = false;
        List<ProdutoBase13> produtosVencidos = new ArrayList<>();
        for (ProdutoBase13 produtoBase13 : produtoBase13s) {
            if (produtoBase13 instanceof ProdutoPerecivel13){
                ProdutoPerecivel13 produtoPerecivel13 = (ProdutoPerecivel13) produtoBase13;
                if (produtoPerecivel13.estaVencido()){
                    produtosVencidos.add(produtoPerecivel13);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto vencido.");
        }else {
            listarProdutos(produtosVencidos);
        }
    }

    public void excluirProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase13s.removeIf(produtoBase13 -> produtoBase13.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto excluido com sucesso");
            return;
        }
        System.out.println("Nenhum produto encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo,double precoMaximo){
        System.out.println("Pesquisa por faixa de preço de R$"+precoMinimo+" e R$"+precoMaximo);
        boolean produtoEncontrado = false;
        List<ProdutoBase13> produtosNaFaixaDePreco = new ArrayList<>();
        for (ProdutoBase13 produtoBase13 : produtoBase13s) {
            if (produtoBase13.getPreco() >= precoMinimo && produtoBase13.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase13);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
        }else {
            listarProdutos(produtosNaFaixaDePreco);
        }
    }

    public List<ProdutoBase13> getProdutoBase13s() {
        return produtoBase13s;
    }
}
