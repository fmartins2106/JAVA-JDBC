package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque19 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase19> produtoBase19s;

    public Estoque19(){
        this.produtoBase19s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase19.validacaoNome(nome);
                return ProdutoBase19.formatoNome(nome);
            }catch (NomeProdutoBase19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase19.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase19.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (QuantidadeProdutoBase19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase19.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel19.validacaoDataValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro, digite uma data válida.");
            }catch (DataValidadePerecivel19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int garantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis19.validacaoMesesGarantia(garantia);
                return garantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis19.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutosSistema(ProdutoBase19 produtoBase19){
        produtoBase19s.add(produtoBase19);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase19s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase19> produtoBase19s){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase19s.forEach(System.out::println);
    }

    public void listarProdutosVencidos(){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase19> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase19 produtoBase19 : produtoBase19s) {
            if (produtoBase19 instanceof ProdutoPerecivel19){
                ProdutoPerecivel19 produtoPerecivel19 = (ProdutoPerecivel19) produtoBase19;
                if (produtoPerecivel19.estaVencido()){
                    produtosVencidos.add(produtoPerecivel19);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosVencidos);
    }

    public Optional<ProdutoBase19> pesquisaPorNome(String nome){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase19s.stream().filter(produtoBase19 -> produtoBase19.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirDados(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase19s.removeIf(produtoBase19 -> produtoBase19.getNome().equalsIgnoreCase(nome));
            System.out.println("Dados excluidos com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase19> produtosDentroDaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase19 produtoBase19 : produtoBase19s) {
            if (produtoBase19.getPreco() >= precoMinimo && produtoBase19.getPreco() <= precoMaximo){
                produtosDentroDaFaixaDePreco.add(produtoBase19);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosDentroDaFaixaDePreco);
    }

    public void exibirPesquisaPorNome(String nome){
        Optional<ProdutoBase19> produtoBase19 = pesquisaPorNome(nome);
        if (produtoBase19.isPresent()){
            System.out.println(produtoBase19.get());
            return;
        }
        System.out.println("Nome não encontrado.");
    }

    public List<ProdutoBase19> getProdutoBase19s() {
        return produtoBase19s;
    }
}
