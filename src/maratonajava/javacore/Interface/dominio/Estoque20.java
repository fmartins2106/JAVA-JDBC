package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque20 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase20> produtoBase20s;

    public Estoque20(){
        this.produtoBase20s = new ArrayList<>();
    }

    public static String validandoNomeProduto(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase20.validacaoNome(nome);
                return ProdutoBase20.formatoString(nome);
            }catch (NomeProdutoBase20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPrecoProduto(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase20.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }catch (PrecoProdutoBase20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase20.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (QuantidadeProdutoBase20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase20.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para estoque mínimo.");
            }catch (EstoqueMinimoProdutoBase20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (dd/mm/aaaa):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel20.validacaoDataValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato dd/mm/aaaa");
            }catch (DataValidadePerecivel20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int garantia = Integer.parseInt(scanner.nextLine());
                ProdutosNaoPereciveis20.validacaoMesesGarantia(garantia);
                return garantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (MesesGarantia20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis20.validacaoCategoria(categoria);
                return ProdutoBase20.formatoString(categoria);
            }catch (CategoriaProdutoInvalido20 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase20 produtoBase20){
        produtoBase20s.add(produtoBase20);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutoCadastrados(){
        if (produtoBase20s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase20s.forEach(System.out::println);
    }

    public void listarProdutoCadastrados(List<ProdutoBase20> produtoBase20s){
        if (produtoBase20s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase20s.forEach(System.out::println);
    }

    public Optional<ProdutoBase20> pesquisaPorNome(String nome){
        if (produtoBase20s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return Optional.empty();
        }
        return produtoBase20s.stream().filter(produtoBase20 -> produtoBase20.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirProdutoSistema(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase20s.removeIf(produtoBase20 -> produtoBase20.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto excluido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    public void exibirPesquisaPorNome(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            System.out.println(pesquisaPorNome(nome).get());
            return;
        }
        System.out.println("Nenhum nome foi encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase20> produtosNaFaixaDePreco = new ArrayList<>();
        Boolean produtoEncontrado = false;
        for (ProdutoBase20 produtoBase20 : produtoBase20s) {
            if (produtoBase20.getPreco() >= precoMinimo && produtoBase20.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase20);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutoCadastrados(produtosNaFaixaDePreco);
    }

    public void listarProdutosVencidos(){
        if (produtoBase20s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase20> produtosVencidos = new ArrayList<>();
        boolean produtoVencidoEncontrado = false;
        for (ProdutoBase20 produtoBase20 : produtoBase20s) {
            if (produtoBase20 instanceof ProdutoPerecivel20){
                ProdutoPerecivel20 produtoPerecivel20 = (ProdutoPerecivel20) produtoBase20;
                if (produtoPerecivel20.estaVencido()){
                    produtosVencidos.add(produtoPerecivel20);
                    produtoVencidoEncontrado = true;
                }
            }
        }
        if (!produtoVencidoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutoCadastrados(produtosVencidos);
    }

    public List<ProdutoBase20> getProdutoBase20s() {
        return produtoBase20s;
    }
}
