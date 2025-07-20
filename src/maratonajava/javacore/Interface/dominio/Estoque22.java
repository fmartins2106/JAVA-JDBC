package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque22 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase22> produtoBase22s;

    public Estoque22(){
        this.produtoBase22s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase22.validacaoNome(nome);
                return ProdutoBase22.formatoString(nome);
            }catch (NomeProdutoBase22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase22.validacaoPreco(preco);
                ProdutoBase22.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (PrecoProdutoBase22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase22.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (QuantidadeProdutoBase22 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase22.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel22.validacaoDataValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida.");
            }catch (DataValidadePerecivel22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int garantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis22.validacaoMesesGarantia(garantia);
                return garantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                return ProdutoBase22.formatoString(categoria);
            }catch (CategoriaProdutoInvalido22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase22 produtoBase22){
        produtoBase22s.add(produtoBase22);
    }

    public void listarProdutosSistemas(){
        if (produtoBase22s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase22s.forEach(System.out::println);
    }

    public void listarProdutosSistemas(List<ProdutoBase22> produtoBase22s){
        if (produtoBase22s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase22s.forEach(System.out::println);
    }

    public void listarProdutoVencidos(){
        if (produtoBase22s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase22> produtosVencidos = new ArrayList<>();
        boolean produtoVencidoEncontrado = false;
        for (ProdutoBase22 produtoBase22 : produtoBase22s) {
            if (produtoBase22 instanceof  ProdutoPerecivel22){
                ProdutoPerecivel22 produtoPerecivel22 = (ProdutoPerecivel22) produtoBase22;
                if (produtoPerecivel22.estaVencido()){
                    produtosVencidos.add(produtoPerecivel22);
                    produtoVencidoEncontrado = true;
                }
            }
        }
        if (!produtoVencidoEncontrado){
            System.out.println("Produto não encontrado.");
            return;
        }
        listarProdutosSistemas(produtosVencidos);
    }

    public Optional<ProdutoBase22> pesquisaPorNome(String nome){
        if (produtoBase22s.isEmpty()){
            System.out.println("Nenhum produto encontrado.");
            return Optional.empty();
        }
        return produtoBase22s.stream().filter(produtoBase22 -> produtoBase22.nome.equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirDados(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase22s.removeIf(produtoBase22 -> produtoBase22.getNome().equalsIgnoreCase(nome));
            return;
        }
        System.out.println("Erro. Nenhum produto encontrado.");
    }

    public void exibirPesquisaPorNome(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            System.out.println(pesquisaPorNome(nome).get());
            return;
        }
        System.out.println("Erro. Nenhum produto encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase22> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase22 produtoBase22 : produtoBase22s) {
            if (produtoBase22.getPreco() >= precoMinimo && produtoBase22.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase22);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Erro. Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosSistemas(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase22> getProdutoBase22s() {
        return produtoBase22s;
    }
}
