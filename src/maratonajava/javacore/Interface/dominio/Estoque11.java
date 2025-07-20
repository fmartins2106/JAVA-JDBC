package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque11 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase11> produtoBase11s;

    public Estoque11(){
        this.produtoBase11s = new ArrayList<>();
    }

    public static String validacaoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase11.validacaoNome(nome);
                return ProdutoBase11.formatoString(nome);
            }catch (NomeProdutoBase11 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validacaoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase11.validacaoPreco(preco);
                return preco;
            }catch (PrecoProdutoBase11 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validacaoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase11.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (QuantidadeProdutoBase11 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validacaoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase11.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para estoque mínimo.");
            }catch (EstoqueMinimoProdutoBase11 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validacaoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade:");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel11.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato dd/mm/aaaa");
            }catch (DataValidadePerecivel11 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int mesesGarantia(){
        while (true){
            try {
                System.out.print("Meses Garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis11.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir meses garantia.");
            }catch (MesesGarantia11 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis11.validacaoCategoria(categoria);
                return ProdutoBase11.formatoString(categoria);
            }catch (CategoriaProdutoInvalido11 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase11 produtoBase11){
        produtoBase11s.add(produtoBase11);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase11s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase11s.forEach(System.out::println);
    }

    public Optional<ProdutoBase11> pesquisaPorNome(String nome){
        if (produtoBase11s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase11s.stream().filter(produtoBase11 -> produtoBase11.getNome().equalsIgnoreCase(nome)).findFirst();
    }

//    public void exibirPesquisaPorNome(String nome){
//        if (pesquisaPorNome(nome).isPresent()){
//            produtoBase11s.forEach(System.out::println);
//        }
//    }


    public void excluirDados(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase11s.removeIf(produtoBase11 -> produtoBase11.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto excluido com sucesso.");
            return;
        }
        System.out.println("Nome não encontrado.");
    }

    public void listarProdutosVencidos(){
        if (produtoBase11s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        for (ProdutoBase11 produtoBase11 : produtoBase11s) {
            if (produtoBase11 instanceof ProdutoPerecivel11){
                ProdutoPerecivel11 produtoPerecivel11 = (ProdutoPerecivel11) produtoBase11;
                produtoPerecivel11.estaVencido();
            }
        }
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        System.out.println("Pesquisa por faixa de preco: de R$"+precoMinimo+" e R$"+precoMaximo);
        List<ProdutoBase11> produtoEncontrado = new ArrayList<>();
        boolean precoEncontrado = false;
        for (ProdutoBase11 produtoBase11 : produtoBase11s) {
            if (produtoBase11.getPreco() >= precoMinimo && produtoBase11.getPreco() <= precoMaximo){
                produtoEncontrado.add(produtoBase11);
                precoEncontrado = true;
            }
        }
        if (!precoEncontrado){
            System.out.println("Nenhum produto nesta faixa de preço.");
        }else {
            produtoEncontrado.forEach(System.out::println);
        }
    }

    public List<ProdutoBase11> getProdutoBase11s() {
        return produtoBase11s;
    }
}
