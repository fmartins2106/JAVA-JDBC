package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque14 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase14> produtoBase14s;

    public Estoque14(){
        this.produtoBase14s = new ArrayList<>();
    }

    public static String validacaoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase14.validacaoNome(nome);
                return ProdutoBase14.formatoString(nome);
            }catch (NomeProdutoBase14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validacaoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase14.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase14.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (QuantidadeProdutoBase14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase14.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido para estoque mínimo.");
            }catch (EstoqueMinimoProdutoBase14 e){
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
                ProdutoPerecivel14.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Data de validade inválida.");
            }catch (DataValidadePerecivel14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis14.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }catch (MesesGarantia14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis14.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutosSistema(ProdutoBase14 produtoBase14){
        produtoBase14s.add(produtoBase14);
        System.out.println("Produto criado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase14s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase14s.forEach(System.out::println);
    }

    private void listarProdutosCadastrados(List<ProdutoBase14> produtoBase14s){
        if (produtoBase14s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase14s.forEach(System.out::println);
    }

    public Optional<ProdutoBase14> pesquisaPorNome(String nome){
        if (produtoBase14s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase14s.stream().filter(produtoBase14 -> produtoBase14.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirDadosPesquisa(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase14s.removeIf(produtoBase14 -> produtoBase14.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto excluido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    public void listarProdutosVencidos(){
        if (produtoBase14s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<ProdutoBase14> produtosVencidos = new ArrayList<>();
        boolean temProdutoVencido = false;
        for (ProdutoBase14 produtoBase14 : produtoBase14s) {
            if (produtoBase14 instanceof ProdutoPerecivel14){
                ProdutoPerecivel14 produtoPerecivel14 = (ProdutoPerecivel14) produtoBase14;
                if (produtoPerecivel14.estaVencido()){
                    produtosVencidos.add(produtoPerecivel14);
                    temProdutoVencido = true;
                }
            }
        }
        if (!temProdutoVencido){
            System.out.println("Nenhum produto vencido encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosVencidos);
    }

    public void listarProdutosPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase14> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase14 produtoBase14 : produtoBase14s) {
            if (produtoBase14.getPreco() >= precoMinimo && produtoBase14.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase14);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Erro. Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase14> getProdutoBase14s() {
        return produtoBase14s;
    }
}
