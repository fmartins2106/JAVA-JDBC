package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque33 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase33> produtoBase33s;

    public Estoque33(){
        this.produtoBase33s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase33.validacaoNomeProduto(nome);
                return ProdutoBase33.formatoString(nome);
            }catch (NomeProdutoBase33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase33.validacaoPrecoProduto(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (PrecoProdutoBase33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase33.validacaoQuantidadeProduto(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (QuantidadeProdutoBase33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase33.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (EstoqueMinimoProdutoBase33 e){
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
                ProdutoPerecivel33.validacaoDataValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato DD/MM/AAAA");
            }catch (DataValidadePerecivel33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPerecivel33.validacaoGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para definir garantia.");
            }catch (MesesGarantia33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPerecivel33.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase33 produtoBase33){
        produtoBase33s.add(produtoBase33);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosSistema(){
        if (produtoBase33s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase33s.forEach(System.out::println);
    }

    public void listarProdutosSistema(List<ProdutoBase33> produtoBase33s){
        if (produtoBase33s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase33s.forEach(System.out::println);
    }

    public void listarProdutosVencidos(){
        if (produtoBase33s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase33> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase33 produtoBase33 : produtoBase33s) {
            if (produtoBase33 instanceof ProdutoPerecivel33){
                ProdutoPerecivel33 produtoPerecivel33 = (ProdutoPerecivel33) produtoBase33;
                if (produtoPerecivel33.estaVencido()){
                    produtosVencidos.add(produtoBase33);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosSistema(produtosVencidos);
    }

    public Optional<ProdutoBase33> pesquisaPorNome(String nome){
        if (produtoBase33s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return Optional.empty();
        }
        return produtoBase33s.stream().filter(produtoBase33 -> produtoBase33.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void exibirPesquisaPorNome(String nome){
        pesquisaPorNome(nome).ifPresentOrElse(System.out::println,
                () -> System.out.println("Nenhum produto foi encontrado."));
    }

    public void excluirProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase33s.removeIf(produtoBase33 -> produtoBase33.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    public void listarProdutosPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase33> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase33 produtoBase33 : produtoBase33s) {
            if (produtoBase33.getPreco() >= precoMinimo && produtoBase33.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase33);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosSistema(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase33> getProdutoBase33s() {
        return produtoBase33s;
    }
}
