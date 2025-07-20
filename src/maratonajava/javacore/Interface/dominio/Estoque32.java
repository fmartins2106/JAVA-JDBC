package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque32 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase32> produtoBase32s;

    public Estoque32(){
        this.produtoBase32s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase32.validacaoNomeProduto(nome);
                return ProdutoBase32.formatoString(nome);
            }catch (NomeProdutoBase32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase32.validacaoPrecoProduto(preco);
                return preco;
            }catch (PrecoProdutoBase32 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir preço.");
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase32.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para definir quantidade.");
            }catch (QuantidadeProdutoBase32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase32.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para definir estoque mínimo.");
            }catch (EstoqueMinimoProdutoBase32 e){
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
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel32.validacaoDataValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida. Digite uma data no formato DD/MM/AAAA");
            }catch (DataValidadePerecivel32  e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int garantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis32.validacaoGarantia(garantia);
                return garantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para definir garantia.");
            }catch (MesesGarantia32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCatagoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis32.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido32 e){
                System.out.println(e.getMessage());
            }
        }
    }


    public void addProdutoSistema(ProdutoBase32 produtoBase32){
        produtoBase32s.add(produtoBase32);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase32s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase32s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase32> produtoBase32s){
        if (produtoBase32s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase32s.forEach(System.out::println);
    }

    public void listaDeProdutosVencidos(){
        if (produtoBase32s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase32> produtosVencidos = new ArrayList<>();
        boolean produtosEncontrados = false;
        for (ProdutoBase32 produtoBase32 : produtoBase32s) {
            if (produtoBase32 instanceof ProdutoPerecivel32){
                ProdutoPerecivel32 produtoPerecivel32 = (ProdutoPerecivel32) produtoBase32;
                if (produtoPerecivel32.estaVencido()){
                    produtosVencidos.add(produtoPerecivel32);
                    produtosEncontrados = true;
                }
            }
        }
        if (!produtosEncontrados){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosVencidos);
    }

    public Optional<ProdutoBase32> pesquisaPorNome(String nome){
        if (produtoBase32s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return Optional.empty();
        }
        return produtoBase32s.stream().filter(produtoBase32 -> produtoBase32.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void exibirPesquisaPorNome(String nome){
        pesquisaPorNome(nome).ifPresentOrElse(System.out::println,
                () -> System.out.println("Nenhum produto encontrado com nome digitado."));
    }

    public void excluirDadosProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase32s.removeIf(produtoBase32 -> produtoBase32.getNome().equalsIgnoreCase(nome));
            System.out.println("Dados removidos com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado com nome digitado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase32> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase32 produtoBase32 : produtoBase32s) {
            if (produtoBase32.getPreco() >= precoMinimo && produtoBase32.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase32);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase32> getProdutoBase32s() {
        return produtoBase32s;
    }
}
