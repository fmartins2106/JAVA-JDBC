package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque30 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase30> produtoBase30s;

    public Estoque30(){
        this.produtoBase30s = new ArrayList<>();
    }

    public static String validandoNomeProduto(){
        while (true){
            try {
                System.out.print("Nome do produto:");
                String nome = scanner.nextLine().trim();
                ProdutoBase30.validacaoNome(nome);
                return ProdutoBase30.formatoString(nome);
            }catch (NomeProdutoBase30 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPrecoProduto(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase30.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Número inválido.");
            }catch (PrecoProdutoBase30 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase30.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Número digitado inválido.");
            }catch (QuantidadeProdutoBase30 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase30.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para estoque mínimo.");
            }catch (EstoqueMinimoProdutoBase30 e){
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
                ProdutoPerecivel30.validacaoDataValidade(validade);
                return validade;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida. Digite uma data no formato DD/MM/AAAA");
            }catch (DataValidadePerecivel30 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoGarantia(){
        while (true){
            try {
                System.out.print("Garantia:");
                int garantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis30.validacaoMesesGarantia(garantia);
                return garantia;
            }catch (MesesGarantia30 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis30.validacaoCategoria(categoria);
                return ProdutoBase30.formatoString(categoria);
            }catch (CategoriaProdutoInvalido30 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase30 produtoBase30){
        produtoBase30s.add(produtoBase30);
        System.out.println("Produto criado com sucesso.");
    }

    public void listaProdutosCadastrados(){
        if (produtoBase30s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase30s.forEach(System.out::println);
    }

    public void listaProdutosCadastrados(List<ProdutoBase30> produtoBase30s){
        if (produtoBase30s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase30s.forEach(System.out::println);
    }

    public Optional<ProdutoBase30> pesquisaPorNome(String nome){
        if (produtoBase30s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase30s.stream().filter(produtoBase30 -> produtoBase30.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void exibirPesquisaNome(String nome){
        pesquisaPorNome(nome).ifPresentOrElse(System.out::println,
                () -> System.out.println("Produto não encontrado."));
    }

    public void excluirProdutoSistema(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase30s.removeIf(produtoBase30 -> produtoBase30.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removidos com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    public void listarProdutosVencidos(){
        List<ProdutoBase30> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase30 produtoBase30 : produtoBase30s) {
            if (produtoBase30 instanceof ProdutoPerecivel30){
                ProdutoPerecivel30 produtoPerecivel30 = (ProdutoPerecivel30) produtoBase30;
                if (produtoPerecivel30.estaVencido()){
                    produtosVencidos.add(produtoBase30);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listaProdutosCadastrados(produtosVencidos);
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase30> listaProdutosEncontrados = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase30 produtoBase30 : produtoBase30s) {
            if (produtoBase30.getPreco() >= precoMinimo && produtoBase30.getPreco() <= precoMaximo){
                listaProdutosEncontrados.add(produtoBase30);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Erro. Nenhum produto foi encontrado.");
            return;
        }
        listaProdutosCadastrados(listaProdutosEncontrados);
    }

    public List<ProdutoBase30> getProdutoBase30s() {
        return produtoBase30s;
    }
}
