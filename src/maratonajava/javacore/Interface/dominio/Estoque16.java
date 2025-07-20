package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque16 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase16> produtoBase16s;

    public Estoque16(){
        this.produtoBase16s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase16.validacaoNome(nome);
                return ProdutoBase16.formatoString(nome);
            }catch (NomeProdutoBase16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase16.validacaoPrecoProduto(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }catch (PrecoProdutoBase16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase16.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }catch (QuantidadeProdutoBase16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase16.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }catch (EstoqueMinimoProdutoBase16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade:");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel16.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite um data válida.");
            }catch (DataValidadePerecivel16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis16.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis16.validacaoCategoria(categoria);
                return ProdutoBase16.formatoString(categoria);
            }catch (CategoriaProdutoInvalido16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoCarrinho(ProdutoBase16 produtoBase16){
        produtoBase16s.add(produtoBase16);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase16s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase16s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase16> produtoBase16s){
        if (produtoBase16s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase16s.forEach(System.out::println);
    }

    public void listarProdutosVencidos(){
        if (produtoBase16s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase16> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase16 produtoBase16 : produtoBase16s) {
            if (produtoBase16 instanceof ProdutoPerecivel16){
                ProdutoPerecivel16 produtoPerecivel16 = (ProdutoPerecivel16) produtoBase16;
                if (produtoPerecivel16.estaVencido()){
                    produtosVencidos.add(produtoPerecivel16);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Erro. Nenhum produto encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosVencidos);
    }

    public Optional<ProdutoBase16> pesquisaPorNome(String nome){
        if (produtoBase16s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return Optional.empty();
        }
        return produtoBase16s.stream().filter(produtoBase16 -> produtoBase16.nome.equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase16s.removeIf(produtoBase16 -> produtoBase16.getNome().equalsIgnoreCase(nome));
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    public void pesquisaPorPreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase16> produtosDaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase16 produtoBase16 : produtoBase16s) {
            if (produtoBase16.getPreco() >= precoMinimo && produtoBase16.getPreco() <= precoMaximo){
                produtosDaFaixaDePreco.add(produtoBase16);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosDaFaixaDePreco);
    }

    public List<ProdutoBase16> getProdutoBase16s() {
        return produtoBase16s;
    }
}
