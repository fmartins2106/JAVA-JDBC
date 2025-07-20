package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque26 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase26> produtoBase26s;

    public Estoque26(){
        this.produtoBase26s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase26.validacaoNome(nome);
                return ProdutoBase26.formatoString(nome);
            }catch (NomeProdutoBase26 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase26.validacaoPreco(valor);
                return valor;
            }catch (PrecoProdutoBase26 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase26.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para quantidade.");
            }catch (QuantidadeProdutoBase26 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase26.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (EstoqueMinimoProdutoBase26 e){
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
                ProdutoPerecivel26.validacaoDataValidade(validade);
                return validade;
            }catch (DateTimeException e){
                System.out.println("Erro, digite uma data válida no formato DD/MM/YYYY");
            }catch (DataValidadePerecivel26 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoGarantia(){
        while (true){
            try {
                System.out.print("Garantia:");
                int garantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis26.validacaoMesesGarantia(garantia);
                return garantia;
            }catch (MesesGarantia26 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis26.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido26 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase26 produtoBase26){
        produtoBase26s.add(produtoBase26);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase26s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase26s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase26> produtoBase26s){
        if (produtoBase26s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase26s.forEach(System.out::println);
    }

    public Optional<ProdutoBase26> pesquisaPorNome(String nome){
        if (produtoBase26s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase26s.stream().filter(produtoBase26 -> produtoBase26.nome.equalsIgnoreCase(nome)).findFirst();
    }

    public void listarProdutosVencidos(){
        if (produtoBase26s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase26> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase26 produtoBase26 : produtoBase26s) {
            if (produtoBase26 instanceof ProdutoPerecivel26){
                ProdutoPerecivel26 produtoPerecivel26 = (ProdutoPerecivel26) produtoBase26;
                if (produtoPerecivel26.estaVencido()){
                    produtosVencidos.add(produtoPerecivel26);
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

    public void excluirProdutoSistema(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase26s.removeIf(produtoBase26 -> produtoBase26.nome.equalsIgnoreCase(nome));
            System.out.println("Dados excluidos com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void exibirPesquisaPorNome(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            System.out.println(pesquisaPorNome(nome).get());
            return;
        }
        System.out.println("Nenhum nome encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase26> produtoNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase26 produtoBase26 : produtoBase26s) {
            if (produtoBase26.getPreco() >= precoMinimo && produtoBase26.getPreco() <= precoMaximo){
                produtoNaFaixaDePreco.add(produtoBase26);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtoNaFaixaDePreco);
    }

    public List<ProdutoBase26> getProdutoBase26s() {
        return produtoBase26s;
    }
}
