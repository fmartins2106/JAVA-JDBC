package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque21 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase21> produtoBase21s;

    public Estoque21(){
        this.produtoBase21s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase21.validacaoNome(nome);
                return ProdutoBase21.formatoString(nome);
            }catch (NomeProdutoBase21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase21.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase21.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (QuantidadeProdutoBase21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase21.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (EstoqueMinimoProdutoBase21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (dd/mm/yyyy):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel21.validacaoDataValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida.");
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis21.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para definir garantia.");
            }catch (MesesGarantia21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis21.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase21 produtoBase21){
        produtoBase21s.add(produtoBase21);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase21s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase21s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase21> produtoBase21s){
        if (produtoBase21s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase21s.forEach(System.out::println);
    }

    public void listarProdutosVencidos(){
        if (produtoBase21s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase21> produtosVencidos = new ArrayList<>();
        boolean produtoVendidoEncontrado = false;
        for (ProdutoBase21 produtoBase21 : produtoBase21s) {
            if (produtoBase21 instanceof ProdutoPerecivel21){
                ProdutoPerecivel21 produtoPerecivel21 = (ProdutoPerecivel21) produtoBase21;
                if (produtoPerecivel21.estaVencido()){
                    produtosVencidos.add(produtoPerecivel21);
                    produtoVendidoEncontrado = true;
                }
            }
        }
        if (!produtoVendidoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosVencidos);
    }

    public Optional<ProdutoBase21> pesquisaPorNome(String nome){
        if (produtoBase21s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return Optional.empty();
        }
        return produtoBase21s.stream().filter(produtoBase21 -> produtoBase21.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirDadosProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase21s.removeIf(produtoBase21 -> produtoBase21.getNome().equalsIgnoreCase(nome));
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
        System.out.println("Nenhum produto foi encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase21> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase21 produtoBase21 : produtoBase21s) {
            if (produtoBase21.getPreco() >= precoMinimo && produtoBase21.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase21);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase21> getProdutoBase21s() {
        return produtoBase21s;
    }
}
