package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque17 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase17> produtoBase17s;

    public Estoque17(){
        this.produtoBase17s = new ArrayList<>();
    }

    public static String validandoNomeProduto(){
        while (true){
            try {
                System.out.print("Nome produto:");
                String nomeProduto = scanner.nextLine().trim();
                ProdutoBase17.validacaoNome(nomeProduto);
                return ProdutoBase17.formatoString(nomeProduto);
            }catch (NomeProdutoBase17 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preco:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase17.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }catch (PrecoProdutoBase17 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase17.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para quantidade.");
            }catch (QuantidadeProdutoBase17 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase17.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase17 e){
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
                ProdutoPerecivel17.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataValidadePerecivel17 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis17.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia17 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis17.validacaoCategoria(categoria);
                return ProdutoBase17.formatoString(categoria);
            }catch (CategoriaProdutoInvalido17 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase17 produtoBase17){
        produtoBase17s.add(produtoBase17);
        System.out.println("Produto cadastrado no sistema com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase17s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase17s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase17> produtoBase17s){
        if (produtoBase17s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase17s.forEach(System.out::println);
    }

    public void listarProdutoVencidos(){
        if (produtoBase17s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase17> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase17 produtoBase17 : produtoBase17s) {
            if (produtoBase17 instanceof ProdutoPerecivel17){
                ProdutoPerecivel17 produtoPerecivel17 = (ProdutoPerecivel17) produtoBase17;
                if (produtoPerecivel17.estaVencido()){
                    produtosVencidos.add(produtoPerecivel17);
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

    public Optional<ProdutoBase17> pesquisaPorNome(String nome){
        if (produtoBase17s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return Optional.empty();
        }
        return produtoBase17s.stream().filter(produtoBase17 -> produtoBase17.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirDadosProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase17s.removeIf(produtoBase17 -> produtoBase17.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto excluido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase17> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase17 produtoBase17 : produtoBase17s) {
            if (produtoBase17.getPreco() >= precoMinimo && produtoBase17.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase17);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase17> getProdutoBase17s() {
        return produtoBase17s;
    }
}
