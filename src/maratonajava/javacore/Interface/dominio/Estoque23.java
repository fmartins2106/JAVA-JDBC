package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque23 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase23> produtoBase23s;

    public Estoque23(){
        this.produtoBase23s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase23.validacaoNome(nome);
                return ProdutoBase23.formatoString(nome);
            }catch (NomeProdutoBase23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase23.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }catch (PrecoProdutoBase23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase23.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (QuantidadeProdutoBase23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase23.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (EstoqueMinimoProdutoBase23 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel23.validacaoDataValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataValidadePerecivel23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis23.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis23.validacaoCategoria(categoria);
                return categoria;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }catch (CategoriaProdutoInvalido23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addprodutoSistema(ProdutoBase23 produtoBase23){
        produtoBase23s.add(produtoBase23);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase23s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase23s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase23> produtoBase23s){
        if (produtoBase23s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase23s.forEach(System.out::println);
    }

    public Optional<ProdutoBase23> pesquisaPorNome(String nome){
        if (produtoBase23s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return Optional.empty();
        }
        return produtoBase23s.stream().filter(produtoBase23 -> produtoBase23.nome.equalsIgnoreCase(nome)).findFirst();
    }
    
    public void listarProdutosVencidos(){
        if (produtoBase23s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase23> produtosVencidos = new ArrayList<>();
        boolean produtoVencidoEncontrado = false;
        for (ProdutoBase23 produtoBase23 : produtoBase23s) {
            if (produtoBase23 instanceof ProdutoPerecivel23){
                ProdutoPerecivel23 produtoPerecivel23 = (ProdutoPerecivel23) produtoBase23;
                if (produtoPerecivel23.estaVencido()){
                    produtosVencidos.add(produtoPerecivel23);
                    produtoVencidoEncontrado = true;
                }
            }
        }
        if (!produtoVencidoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosVencidos);
    }

    public void exibirPesquisaPorNome(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            System.out.println(pesquisaPorNome(nome).get());
            return;
        }
        System.out.println("Nenhum nome encontrado.");
    }

    public void excluirProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase23s.removeIf(produtoBase23 -> produtoBase23.nome.equalsIgnoreCase(nome));
            System.out.println("Produto excluido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase23> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtosEncontrados = false;
        for (ProdutoBase23 produtoBase23 : produtoBase23s) {
            if (produtoBase23.getPreco() >= precoMinimo && produtoBase23.preco <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase23);
                produtosEncontrados = true;
            }
        }
        if (!produtosEncontrados){
            System.out.println("Erro. Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase23> getProdutoBase23s() {
        return produtoBase23s;
    }
}
